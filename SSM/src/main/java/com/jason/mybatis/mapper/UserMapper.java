package com.jason.mybatis.mapper;

import com.jason.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author Jason
 * @date 2022/7/30 19:39
 * @Description
 */
public interface UserMapper {
    //添加用户
    int insertUser(User user);


    //根据id查找用户
    User getUserById();

    //查询所有用户对象
    List<User> getAllUsers();

    //根据用户名查找用户
    User getUserByUsername(String username);

    //验证登录
    User login(String username, String password);

    //
    User checkLoginByMap(Map<String,Object> map);
}
