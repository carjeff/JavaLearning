package transaction;

import org.junit.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Jason
 * @date 2022/7/21 08:57
 * @Description
 */
public class TransactionTest {
    @Test
    public void test1() throws Exception{

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            //取消数据的自动提交
            connection.setAutoCommit(false);
            String sql = "update user_table set balance = balance - 100 where user = ?";
            update(connection,sql,"AA");

            System.out.println(10/0);
            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            update(connection,sql2,"BB");

            System.out.println("转账成功");

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            JDBCUtils.closeResource(connection,null);
        }


    }


    //考虑数据库事务的通用增删改操作
    public void update(Connection connection,String sql, Object ...args){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i< args.length; i++){
                ps.setObject(i+1, args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null,ps);
        }
    }


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
}


