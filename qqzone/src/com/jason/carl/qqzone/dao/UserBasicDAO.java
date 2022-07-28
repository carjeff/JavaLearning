package com.jason.carl.qqzone.dao;

import com.jason.carl.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Jason
 * @date 2022/7/27 20:03
 * @Description
 */
public interface UserBasicDAO {
    //根据账号密码获取用户信息
    UserBasic getUserBasic(String loginId, String pwd);

    //根据用户获取所有好友列表
    List<UserBasic> getFriendList(UserBasic userBasic);
}
