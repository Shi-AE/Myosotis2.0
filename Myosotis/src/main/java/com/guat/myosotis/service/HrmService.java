package com.guat.myosotis.service;

import com.guat.myosotis.bean.Admin;

/**
 * 账号管理服务
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface HrmService {

    /**
     * 重置用户密码
     * @param account 账号
     * @param password 密码
     * @return
     */
    boolean updateUserPassword(String account, String password);

    /**
     * 重置管理员密码
     * @param account 账号
     * @param password 密码
     * @return
     */
    boolean updateAdminPassword(String account, String password);

    /**
     * 添加管理原
     * @param admin 管理员信息
     * @return 成功
     */
    boolean AddAdmin(Admin admin,String password);
}
