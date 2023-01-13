package com.guat.myosotis.dao;

import com.guat.myosotis.bean.Document;

import java.util.List;

/**
 * 文件操作类
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface DocumentDao {
    /**
     * 添加文件
     *
     * @param document 文件信息
     * @return 添加数量
     */
    int insert(Document document);

    /**
     * 获取文件信息列表
     *
     * @param employ 员工编号
     * @return 信息列表
     */
    List<Document> selectAll(String employ);

    /**
     * 通过id查找文件
     *
     * @param id 文件编号
     * @return 文件流
     */
    byte[] selectFileById(Long id);

    /**
     * 通过id删除文件
     *
     * @param id 文件编号
     * @return 删除数量
     */
    int deleteFileById(Long id);
}
