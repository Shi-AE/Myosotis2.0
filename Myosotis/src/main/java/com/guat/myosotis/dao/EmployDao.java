package com.guat.myosotis.dao;

import com.guat.myosotis.bean.Employ;

import java.util.List;

/**
 * 员工表操作
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface EmployDao {
    /**
     * 通过员工姓名查找员工编号
     *
     * @param name 员工名
     * @return 员工编号
     */
    String selectEmployIdByName(String name);

    /**
     * 数据库增加员工信息
     *
     * @param employ 员工对象
     */
    void insertEmploy(Employ employ);

    /**
     * 查询所有员工名字
     * @return 员工名字集合
     */
    List<String> selectAllName();

    /**
     * 通过员工编号查找员工姓名
     *
     * @param employId 员工编号
     * @return 员工姓名
     */
    String selectNameByEmployId(String employId);
}
