package com.guat.myosotis.dao.impl;

import com.guat.myosotis.bean.Announce;
import com.guat.myosotis.dao.AnnounceDao;
import com.guat.myosotis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AnnounceDaoImpl implements AnnounceDao {
    @Override
    public int insert(Announce announce) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.insert("announce.insert", announce);
    }

    @Override
    public List<Announce> selectAllAnnounce() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectList("announce.selectAll");
    }

    @Override
    public String selectUrlById(Long id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectOne("announce.selectUrlById", id);
    }

    @Override
    public int deleteById(Long id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.delete("announce.deleteById", id);
    }

}
