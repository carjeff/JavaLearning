package com.jason.carl.qqzone.service.impl;

import com.jason.carl.qqzone.dao.TopicDAO;
import com.jason.carl.qqzone.pojo.Topic;
import com.jason.carl.qqzone.pojo.UserBasic;
import com.jason.carl.qqzone.service.TopicService;

import java.util.List;

/**
 * @author Jason
 * @date 2022/7/29 09:18
 * @Description
 */
public class TopicServiceImpl implements TopicService {

    private TopicDAO topicDAO = null;
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }
}
