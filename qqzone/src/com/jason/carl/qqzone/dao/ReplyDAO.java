package com.jason.carl.qqzone.dao;

import com.jason.carl.qqzone.pojo.Reply;
import com.jason.carl.qqzone.pojo.Topic;

import java.util.List;

/**
 * @author Jason
 * @date 2022/7/27 20:10
 * @Description
 */
public interface ReplyDAO {
    //获取指定话题的所有回复
    List<Reply> getReplyList(Topic topic);
    //添加回复
    void addReply(Reply reply);
    //删除回复
    void delReply(Integer id);
}
