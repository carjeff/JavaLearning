package preparedStatement;

import bean.Order;
import org.junit.Test;
import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author Jason
 * @date 2022/7/20 14:37
 * @Description
 */
public class OderForQuery {

    @Test
    public void testOrderForQuery(){
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        Order order = orderForQuery(sql, 4);
        System.out.println(order);

    }

    /**
     * 通用的order表的查询操作
     * @return
     */
    public Order orderForQuery(String sql, Object ...args) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i =0; i<args.length; i++){
                ps.setObject(i+1,args[i]);
            }

            resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()){
                Order order = new Order();
                for (int i=0; i<columnCount; i++){
                    Object columnValue = resultSet.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order,columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,ps,resultSet);
        }
        return null;

    }



    @Test
    public void testQuery1() throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select order_id,order_name,order_date from `order` where order_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,1);
            resultSet = ps.executeQuery();
            if (resultSet.next()){
                int id = (int) resultSet.getObject(1);
                String name = (String) resultSet.getObject(2);
                Date date = (Date) resultSet.getObject(3);
                Order order = new Order(id,name,date);
                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,ps,resultSet);
        }

    }
}
