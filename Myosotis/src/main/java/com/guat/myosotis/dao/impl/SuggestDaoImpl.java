package com.guat.myosotis.dao.impl;

import com.guat.myosotis.bean.Suggest;
import com.guat.myosotis.dao.SuggestDao;
import com.guat.myosotis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SuggestDaoImpl implements SuggestDao {
    @Override
    public int insert(Suggest suggest) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.insert("suggest.insert", suggest);
    }

    @Override
    public List<Suggest> selectAllByTarget(String target) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectList("suggest.selectAll", target);
    }

    @Override
    public int deleteById(Long id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.delete("suggest.deleteById", id);
    }
}
