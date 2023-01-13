package com.guat.myosotis.dao;

import com.guat.myosotis.bean.Suggest;

import java.util.List;

/**
 * 建议操作
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface SuggestDao {
    /**
     * 添加
     *
     * @param suggest 信息
     * @return 添加数量
     */
    int insert(Suggest suggest);

    /**
     * 通过目标查寻建议
     *
     * @param target 发送目标
     * @return 建议列表
     */
    List<Suggest> selectAllByTarget(String target);

    int deleteById(Long id);
}
