package com.guat.myosotis.dao;

import com.guat.myosotis.bean.Admin;
import com.guat.myosotis.bean.Cipher;

import java.util.List;

/**
 * 管理员表操作类
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface AdminDao {

    /**
     * 查询通过账号
     *
     * @param account 账号
     * @return 密文对象
     */
    Cipher selectByAccount(String account);

    /**
     * 重置密码
     *
     * @param admin
     * @return
     */
    int updatePasswordByAccount(Admin admin);

    /**
     * 添加管理员
     *
     * @param admin 管理员信息
     * @return
     */
    int insertAdmin(Admin admin);

    /**
     * 获取所有管理员信息
     *
     * @return 管理员信息列表
     */
    List<Admin> selectAllAdmin();
}
