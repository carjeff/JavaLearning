package com.jason.carl.qqzone.controller;

import com.jason.carl.qqzone.pojo.Topic;
import com.jason.carl.qqzone.pojo.UserBasic;
import com.jason.carl.qqzone.service.TopicService;
import com.jason.carl.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Jason
 * @date 2022/7/29 09:21
 * @Description
 */
public class UserController {
    private UserBasicService userBasicService;
    private TopicService topicService;
    public String login(String loginId, String pwd, HttpSession session){
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if (userBasic != null){
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);
            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            session.setAttribute("userBasic", userBasic);
            return "index";
        }else {
            return "login";
        }
    }
}
