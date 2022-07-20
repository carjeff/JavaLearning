package preparedStatement;

import bean.Customer;
import org.junit.Test;
import util.JDBCUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

/**
 * @author Jason
 * @date 2022/7/20 20:38
 * @Description
 */
public class BlobTest {

    @Test
    public void BlobForQuery() throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //连接数据库
            connection = JDBCUtils.getConnection();
            //sql语句
            String sql = "select id,name,email,birth,photo from customers where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,20);
            resultSet = ps.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
                Customer customer = new Customer(id,name,email,birth);
                System.out.println(customer);

                Blob photo = resultSet.getBlob(5);
                is = photo.getBinaryStream();
                fos = new FileOutputStream("photos/new.jpeg");
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer))!= -1) {
                    fos.write(buffer,0,len);
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            is.close();
            fos.close();
            JDBCUtils.closeResource(connection,ps,resultSet);
        }


    }


    @Test
    public void updateBlob() throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Scanner scanner = new Scanner(System.in);
            //连接数据库
            connection = JDBCUtils.getConnection();
            //sql语句
            String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,"许天翔");
            ps.setObject(2,"skyflycry@gmail.com");
            ps.setObject(3,"2021-12-21");
            FileInputStream is = new FileInputStream(new File("/Users/car/code/JavaLearning/JDBC/photos/1.jpeg"));
            ps.setBlob(4,is);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,ps);
        }

    }
}
