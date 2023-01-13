package com.guat.myosotis.service;

import com.guat.myosotis.bean.MyMeeting;

import java.util.List;

/**
 * 自定会议管理
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface MyMeetingService {
    /**
     * 存入我的会议并入员工编号
     *
     * @param myMeeting 会议信息
     * @return 是否成功
     */
    boolean insert(MyMeeting myMeeting, String account);

    /**
     * 获取员工信息对应的会议信息
     * @return 会议信息泪列表
     */
    List<MyMeeting> getAllMeeting(String account);

    /**
     * 通过ID删除会议日程
     * @param id 会议
     * @return
     */
    boolean deleteMeeting(String id);
}
