package com.guat.myosotis.dao;

import com.guat.myosotis.bean.Property;

import java.util.List;

/**
 * 项目资产操作
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface PropertyDao {
    /**
     * 添加项目
     *
     * @param property 项目信息
     * @return
     */
    int insert(Property property);

    /**
     * 读取项目列表
     * @return
     */
    List<Property> selectAll();

    /**
     *
     * @return
     */
    int updatePropertyById(Property property);

    /**
     * 通过id删除
     * @param id 编号
     * @return 删除数量
     */
    int deletePropertyById(Long id);
}
