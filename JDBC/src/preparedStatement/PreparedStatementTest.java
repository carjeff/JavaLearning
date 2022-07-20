package preparedStatement;

import connection.ConnectionTest;
import org.junit.Test;
import util.JDBCUtils;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @author Jason
 * @date 2022/7/20 13:35
 * @Description
 */
public class PreparedStatementTest {
    @Test
    public void test () {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //读取配置文件中的4个基本信息

            InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

            Class.forName(driverClass);
            //获取连接
            connection = DriverManager.getConnection(url,user,password);

            //预编译sql语句
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            ps = connection.prepareStatement(sql);
            //填充占位符
            ps.setString(1,"哪吒");
            ps.setString(2,"nezha@gamil.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date d = sdf.parse("1000-01-01");
            ps.setDate(3,new Date(d.getTime()));

            //执行sql
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //资源关闭
            try {
                if (ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null){
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testUpdate() throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //获取数据库连接
            connection = JDBCUtils.getConnection();
            //预编译sql语句
            String sql= "update customers set name = ? where id = ?";
            ps = connection.prepareStatement(sql);
            //填充占位符
            ps.setString(1,"莫扎特");
            ps.setObject(2,18);
            //执行
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //资源的关闭
            JDBCUtils.closeResource(connection,ps);
        }
    }

    /*
    通用的增删改操作
     */
    public void update(String sql, Object ...args){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i< args.length; i++){
                ps.setObject(i+1, args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,ps);
        }
    }

    @Test
    public void testCommonUpdate(){
        String sql = "delete from customers where id = ?";
        update(sql,12);
    }


}
