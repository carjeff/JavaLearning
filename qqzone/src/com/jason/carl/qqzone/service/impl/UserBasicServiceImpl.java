package com.jason.carl.qqzone.service.impl;

import com.jason.carl.qqzone.dao.UserBasicDAO;
import com.jason.carl.qqzone.pojo.UserBasic;
import com.jason.carl.qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason
 * @date 2022/7/29 08:58
 * @Description
 */
public class UserBasicServiceImpl implements UserBasicService {

    private UserBasicDAO userBasicDAO = null;
    @Override
    public UserBasic login(String loginId, String pwd) {
        //登录验证
        UserBasic userBasic = userBasicDAO.getUserBasic(loginId, pwd);
        return userBasic;
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> userBasicList = userBasicDAO.getFriendList(userBasic);
        List<UserBasic> friendList = new ArrayList<>(userBasicList.size());
        for (int i = 0; i< userBasicList.size();i++){
            UserBasic friend = userBasicList.get(i);
            friend = userBasicDAO.getUserBasicById(friend.getId());
            friendList.add(friend);
        }
        return friendList;
    }
}
