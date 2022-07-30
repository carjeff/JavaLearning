package com.jason.carl.qqzone.dao.impl;

import com.jason.carl.myssm.basedao.BaseDAO;
import com.jason.carl.qqzone.dao.UserBasicDAO;
import com.jason.carl.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Jason
 * @date 2022/7/27 20:13
 * @Description
 */
public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {

        return super.load("select * from t_user_basic where loginId = ? and pwd = ?",loginId,pwd);


    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        String sql = "select fid from t_friend where uid = ?";
        return super.executeQuery(sql,userBasic.getId());
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return super.load("select * from t_user_basic where id = ?" , id);
    }
}
