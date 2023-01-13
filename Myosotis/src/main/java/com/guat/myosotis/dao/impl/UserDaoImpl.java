package com.guat.myosotis.dao.impl;

import com.guat.myosotis.bean.Cipher;
import com.guat.myosotis.bean.User;
import com.guat.myosotis.dao.UserDao;
import com.guat.myosotis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao {
    @Override
    public Cipher selectByEmil(String emil) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectOne("user.selectByEmil", emil);
    }

    @Override
    public Cipher selectByPhoneNumber(String phoneNumber) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectOne("user.selectByPhoneNumber", phoneNumber);
    }

    @Override
    public void updateTokenByEmil(String emil, String token) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        User user = new User();
        user.setEmil(emil);
        user.setToken(token);
        sqlSession.update("user.updateTokenByEmil", user);
    }

    @Override
    public void updateTokenByPhoneNumber(String phoneNumber, String token) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        User user = new User();
        user.setPhoneNumber(phoneNumber);
        user.setToken(token);
        sqlSession.update("user.updateTokenByPhoneNumber", user);
    }

    @Override
    public User selectByToken(String token) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectOne("user.selectByToken", token);
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.insert("user.insertUser", user);
    }

    @Override
    public String selectEmployIdByPhoneNumber(String phoneNumber) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectOne("user.selectEmployIdByPhoneNumber", phoneNumber);
    }

    @Override
    public String selectEmployIdByEmil(String emil) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectOne("user.selectEmployIdByEmil", emil);
    }

    @Override
    public int updatePasswordByEmil(User user) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.update("user.updatePasswordByEmil",user);
    }

    @Override
    public int updatePasswordByPhoneNumber(User user) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.update("user.updatePasswordByPhoneNumber",user);
    }
}
