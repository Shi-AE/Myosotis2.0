package com.guat.myosotis.service;

import com.guat.myosotis.bean.Admin;
import com.guat.myosotis.exceptions.AccountErrException;
import com.guat.myosotis.exceptions.EmilErrException;
import com.guat.myosotis.exceptions.NumberErrException;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * 登录业务
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface EntryService {
    /**
     * 用户密码检验
     *
     * @param account  账号
     * @param password 密码
     * @return 密码是否正确
     */
    boolean userVerify(String account, String password) throws NullPointerException, EmilErrException, NumberErrException;

    /**
     * 管理员密码校验
     *
     * @param account  账号
     * @param password 密码
     * @return 密码是否正确
     */
    boolean adminVerify(String account, String password) throws NullPointerException, AccountErrException;

    /**
     * 生成，存放token
     *
     * @param account 账号
     * @param ip      ip地址
     */
    void creatAndSaveToken(String account, String ip, HttpServletResponse resp);

    /**
     * 查看token是否匹配
     *
     * @return 邮箱
     */
    String tokenVerify(String token);

    /**
     * 获取员工编号
     *
     * @param account
     * @return
     */
    String getEmployId(String account);

    /**
     * 获取所有管理员信息
     *
     * @return 管理员信息列表
     */
    List<Admin> getAdminList();
}
