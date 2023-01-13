package com.guat.myosotis.dao;

import com.guat.myosotis.bean.Announce;

import java.util.List;

/**
 * 公告管理
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface AnnounceDao {
    /**
     * 添加公告
     *
     * @param announce 公告信息
     * @return 添加数量
     */
    int insert(Announce announce);

    /**
     * 查询所有公告
     *
     * @return 公告列表
     */
    List<Announce> selectAllAnnounce();

    /**
     * 通过id查路径
     *
     * @param id
     * @return
     */
    String selectUrlById(Long id);

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    int deleteById(Long id);
}
