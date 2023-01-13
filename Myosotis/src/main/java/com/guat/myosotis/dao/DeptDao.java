package com.guat.myosotis.dao;

import java.util.List;

/**
 * 部门表操作
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface DeptDao {

    /**
     * 通过部门名查找部门编号
     * @param deptName 部门名
     * @return 编号
     */
    String selectDeptIdByName(String deptName);

    /**
     * 查询所有部门集合
     * @return 部门名集合
     */
    List<String> selectAllName();
}
