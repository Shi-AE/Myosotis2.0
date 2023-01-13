package com.guat.myosotis.service;

import com.guat.myosotis.bean.Suggest;

import java.util.List;

/**
 * 建议服务
 */
public interface SuggestService {
    /**
     * 获取员工编号
     * 建议添加至服务器
     *
     * @param target  目标姓名
     * @param content 内容
     * @return 是否成功
     */
    boolean insert(String target, String content, String sender);

    /**
     * 查询建议列表
     *
     * @param target 发送目标
     * @return 建议列表
     */
    List<Suggest> getAllSuggest(String target);

    boolean deleteSuggest(String id);
}
