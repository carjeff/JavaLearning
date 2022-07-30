package com.jason.carl.qqzone.dao.impl;

import com.jason.carl.myssm.basedao.BaseDAO;
import com.jason.carl.qqzone.dao.TopicDAO;
import com.jason.carl.qqzone.pojo.Topic;
import com.jason.carl.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Jason
 * @date 2022/7/29 08:54
 * @Description
 */
public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return super.executeQuery("select * from t_topic where author = ?",userBasic.getId());
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public void delTopic(Topic topic) {

    }

    @Override
    public Topic getTopic(Integer id) {
        return null;
    }
}
