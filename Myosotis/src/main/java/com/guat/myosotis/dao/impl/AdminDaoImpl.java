package com.guat.myosotis.dao.impl;

import com.guat.myosotis.bean.Admin;
import com.guat.myosotis.bean.Cipher;
import com.guat.myosotis.dao.AdminDao;
import com.guat.myosotis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Cipher selectByAccount(String account) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectOne("admin.selectByAccount", account);
    }

    @Override
    public int updatePasswordByAccount(Admin admin) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.update("admin.updatePasswordByAccount", admin);
    }

    @Override
    public int insertAdmin(Admin admin) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.insert("admin.insertAdmin",admin);
    }

    @Override
    public List<Admin> selectAllAdmin() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectList("admin.selectAllAdmin");
    }
}
