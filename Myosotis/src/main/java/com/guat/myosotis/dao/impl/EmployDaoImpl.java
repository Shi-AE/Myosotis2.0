package com.guat.myosotis.dao.impl;

import com.guat.myosotis.bean.Employ;
import com.guat.myosotis.dao.EmployDao;
import com.guat.myosotis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployDaoImpl implements EmployDao {
    @Override
    public String selectEmployIdByName(String name) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectOne("employ.selectEmployIdByName", name);
    }

    @Override
    public void insertEmploy(Employ employ) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.insert("employ.insertEmploy", employ);
    }

    @Override
    public List<String> selectAllName() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectList("employ.selectAllName");
    }

    @Override
    public String selectNameByEmployId(String employId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectOne("employ.selectNameByEmployId", employId);
    }
}
