package com.guat.myosotis.dao.impl;

import com.guat.myosotis.bean.MyMeeting;
import com.guat.myosotis.dao.MyMeetingDao;
import com.guat.myosotis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyMeetingDaoImpl implements MyMeetingDao {
    @Override
    public int insert(MyMeeting myMeeting) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.insert("myMeeting.insert", myMeeting);
    }

    @Override
    public List<MyMeeting> selectAllByEmploy(String employId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectList("myMeeting.selectAllByEmploy",employId);
    }

    @Override
    public int deleteById(Long id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.delete("myMeeting.deleteById", id);
    }
}
