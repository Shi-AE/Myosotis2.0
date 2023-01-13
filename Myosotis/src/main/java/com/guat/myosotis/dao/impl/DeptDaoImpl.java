package com.guat.myosotis.dao.impl;

import com.guat.myosotis.dao.DeptDao;
import com.guat.myosotis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptDaoImpl implements DeptDao {
    @Override
    public String selectDeptIdByName(String deptName) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectOne("dept.selectDeptIdByName", deptName);
    }

    @Override
    public List<String> selectAllName() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectList("dept.selectAllName");
    }
}
