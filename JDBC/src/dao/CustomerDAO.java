package dao;

import bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author Jason
 * @date 2022/7/21 10:31
 * @Description 此接口用于规范对于customer表的常用操作
 */
public interface CustomerDAO {
    //添加
    void insert(Connection connection, Customer customer);
    //删除
    void deleteById(Connection connection,int id);
    //修改
    void updateById(Connection connection,Customer customer);
    //查询
    Customer getCustomerById(Connection connection,int id);
    //查询多条记录
    List<Customer> getAll(Connection connection);
    //查询数据条数
    Long getCount(Connection connection);
    //查询日期
    Date getBirth(Connection connection);
}
