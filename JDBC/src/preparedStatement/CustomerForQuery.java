package preparedStatement;

import bean.Customer;
import org.junit.Test;
import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author Jason
 * @date 2022/7/20 14:06
 * @Description
 */
public class CustomerForQuery {

    @Test
    public void testQueryForCustomers(){
        String sql = "select id,name,birth,email from customers where id = ?";
        String sql2 = "select name,email from customers where name = ?";
        Customer customer = queryForCustomers(sql2, "周杰伦");
        System.out.println(customer);



    }

    public Customer queryForCustomers(String sql, Object ...args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i< args.length; i++){
                ps.setObject(i+1, args[i]);
            }

            resultSet = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()){
                Customer customer = new Customer();
                for (int i =0; i<columnCount;i++){
                    Object value = resultSet.getObject(i + 1);

                    //获取每个列的列名
                    String columnName = metaData.getColumnName(i + 1);
                    //通过反射赋值
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(customer,value);
                }
                return customer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,ps,resultSet);
        }

        return null;
    }

    @Test
    public void testQuery() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,1);

            resultSet = ps.executeQuery();
            //处理结果集
            if (resultSet.next()){ //判断结果集的下一条是否有数据，如果有，返回true，并指针下移
                //获取当前数据的各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date date = resultSet.getDate(4);


                Customer customer = new Customer(id, name, email, date);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,ps,resultSet);
        }

    }
}
