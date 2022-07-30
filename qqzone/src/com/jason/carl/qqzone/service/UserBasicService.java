package com.jason.carl.qqzone.service;

import com.jason.carl.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Jason
 * @date 2022/7/29 08:57
 * @Description
 */
public interface UserBasicService {
    //登录业务
    UserBasic login(String loginId, String pwd);
    //得到好友列表
    List<UserBasic> getFriendList(UserBasic userBasic);
}
