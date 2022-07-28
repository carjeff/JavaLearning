package com.jason.carl.qqzone.dao;

import com.jason.carl.qqzone.pojo.Topic;
import com.jason.carl.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Jason
 * @date 2022/7/27 20:07
 * @Description
 */
public interface TopicDAO {

    //获取指定用户的所有日志
    List<Topic> getTopicList(UserBasic userBasic);
    //添加日志
    void addTopic(Topic topic);
    //删除日志
    void delTopic(Topic topic);
    //根据id获取指定日志信息
    Topic getTopic(Integer id);
}
