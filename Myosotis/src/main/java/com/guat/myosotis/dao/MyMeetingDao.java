package com.guat.myosotis.dao;

import com.guat.myosotis.bean.MyMeeting;

import java.util.List;

/**
 * 我的会议操作
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface MyMeetingDao {

    /**
     * 添加我的会议
     * @param myMeeting 会议信息
     * @return 添加数量
     */
    int insert(MyMeeting myMeeting);

    /**
     * 通过员工编号读取会议信息列表
     * @return 会议信息列表
     */
    List<MyMeeting> selectAllByEmploy(String employId);

    /**
     * 通过id删除
     * @param id 会议编号
     * @return 删除数量
     */
    int deleteById(Long id);

}
