package preparedStatement;

import bean.Customer;
import bean.Order;
import org.junit.Test;
import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author Jason
 * @date 2022/7/20 15:21
 * @Description
 */
public class PreparedStatementQueryTest {

    @Test
    public void testGetInstance(){
        String sql = "select id,name,email from customers where id =?";
        Customer customer = getInstance(Customer.class, sql, 10);
        System.out.println(customer);

        String sql1 = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        Order order = getInstance(Order.class, sql1, 1);
        System.out.println(order);

    }

    public <T> T getInstance(Class<T> clazz, String sql, Object ...args){
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
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i =0; i<columnCount;i++){
                    Object value = resultSet.getObject(i + 1);

                    //获取每个列的列名
                    String columnName = metaData.getColumnLabel(i + 1);
                    //通过反射赋值
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,ps,resultSet);
        }
        return null;
    }
}
