package com.guat.myosotis.service;

import com.guat.myosotis.bean.Announce;

import java.util.List;

/**
 * 公告管理
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface AnnounceService {
    /**
     * 添加公告
     *
     * @param announce 公告信息
     * @return 是否成功
     */
    boolean insertAnnounce(Announce announce);

    /**
     * 获取所有公告
     *
     * @return 公告信息表
     */
    List<Announce> getAllAnnounce();

    /**
     * 删除公告
     *
     * @return 是否成功删除
     */
    boolean deleteAnnounce(String id,String path);
}
