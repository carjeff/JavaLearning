package com.jason.carl.qqzone.service;

import com.jason.carl.qqzone.pojo.Topic;
import com.jason.carl.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Jason
 * @date 2022/7/29 09:17
 * @Description
 */
public interface TopicService {
    List<Topic> getTopicList(UserBasic userBasic);
}
