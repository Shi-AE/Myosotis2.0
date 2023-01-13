package com.guat.myosotis.service;

import com.guat.myosotis.bean.Property;

import java.util.List;

/**
 * 项目资产服务
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface PropertyService {
    /**
     * 添加项目
     *
     * @param property 项目信息
     * @return 成功
     */
    boolean addProperty(Property property);

    /**
     * 获取项目资产列表
     *
     * @return 项目资产列表
     */
    List<Property> getPropertyList();

    /**
     * 更改项目数量
     *
     * @param id 编号
     * @param number 数量
     * @return 成功
     */
    boolean updateProperty(String id, String number);

    /**
     * 删除项目
     * @param id 项目编号
     * @return 成功
     */
    boolean deleteProperty(String id);
}
