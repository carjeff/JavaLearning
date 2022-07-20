package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Jason
 * @date 2022/7/20 13:46
 * @Description
 */
public class JDBCUtils {

    /**
     * 获取数据库连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        //读取配置文件中的4个基本信息

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }


    public static void closeResource(Connection connection, Statement ps){
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

    public static void closeResource(Connection connection, Statement ps, ResultSet resultSet){
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
        try {
            if (resultSet != null){
                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
