package connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Jason
 * @date 2022/7/20 10:15
 * @Description
 */
public class ConnectionTest {
    @Test
    public void testConnection1() throws Exception {
        //1. 注册驱动
        /*

            #org.quartz.dataSource.qzDS.driver:com.mysql.cj.jdbc.Driver
            #org.quartz.dataSource.qzDS.URL:jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false
         */


        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获取连接

        String url ="jdbc:mysql://localhost:3306/jdbc_learn?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "chezijie";
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);

//        //3. 定义sql
//        String sql = "select * from customers";
//
//        //4. 执行获取sql的对象statement
//        Statement statement = connection.createStatement();
//
//        //5. 执行sql
//        int count = statement.executeUpdate(sql);
//
//        System.out.println(count);
//
//
//        statement.close();
        connection.close();
    }
    // 通过使用读取配置文件的方式，获取连接  最终版
    // 实现了数据与代码的分离，实现了解耦
    // 如果需要修改配置文件信息，可以避免程序重新打包
    @Test
    public void getConnection() throws Exception {
        //读取配置文件中的4个基本信息

        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }

}
