package com.guat.myosotis.service.impl;

import com.guat.myosotis.bean.MyMeeting;
import com.guat.myosotis.dao.MyMeetingDao;
import com.guat.myosotis.dao.UserDao;
import com.guat.myosotis.dao.impl.MyMeetingDaoImpl;
import com.guat.myosotis.dao.impl.UserDaoImpl;
import com.guat.myosotis.service.MyMeetingService;
import com.guat.myosotis.util.SqlSessionUtil;

import java.util.List;

public class MyMeetingServiceImpl implements MyMeetingService {
    @Override
    public boolean insert(MyMeeting myMeeting, String account) {
        MyMeetingDao meetingDao = new MyMeetingDaoImpl();
        UserDao userDao = new UserDaoImpl();
        //查询员工编号
        String employId;
        if (account.contains("@")) {
            employId = userDao.selectEmployIdByEmil(account);
        } else {
            employId = userDao.selectEmployIdByPhoneNumber(account);
        }
        //合并会议信息
        myMeeting.setEmployId(employId);
        try {
            //存入会议信息
            int count = meetingDao.insert(myMeeting);
            SqlSessionUtil.commitSqlSession();
            return count == 1;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
    }

    @Override
    public List<MyMeeting> getAllMeeting(String account) {
        MyMeetingDao myMeetingDao = new MyMeetingDaoImpl();
        UserDao userDao = new UserDaoImpl();
        String employId;
        try {
            if (account.contains("@")) {
                employId = userDao.selectEmployIdByEmil(account);
            } else {
                employId = userDao.selectEmployIdByPhoneNumber(account);
            }
            SqlSessionUtil.commitSqlSession();
            return myMeetingDao.selectAllByEmploy(employId);
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
    }

    @Override
    public boolean deleteMeeting(String sId) {
        Long id = Long.valueOf(sId);
        MyMeetingDao myMeetingDao = new MyMeetingDaoImpl();
        try {
            int count = myMeetingDao.deleteById(id);
            SqlSessionUtil.commitSqlSession();
            return count == 1;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
    }


}
