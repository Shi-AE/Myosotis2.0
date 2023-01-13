package com.guat.myosotis.dao;

import com.guat.myosotis.bean.Cipher;
import com.guat.myosotis.bean.User;

/**
 * 用户表操作类
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface UserDao {

    /**
     * 通过邮箱查询
     *
     * @param emil 邮箱
     * @return 密文对象
     */
    Cipher selectByEmil(String emil);

    /**
     * 通过手机号查询
     *
     * @param phoneNumber 手机号
     * @return 密文对象
     */
    Cipher selectByPhoneNumber(String phoneNumber);

    /**
     * 通过邮箱更新token
     *
     * @param emil 邮箱
     */
    void updateTokenByEmil(String emil, String token);

    /**
     * 通过手机号更新token
     *
     * @param phoneNumber 手机号
     */
    void updateTokenByPhoneNumber(String phoneNumber, String token);

    /**
     * 通过token查找邮箱或者手机号码
     *
     * @param token
     * @return User 的邮箱或者手机号码
     */
    User selectByToken(String token);

    /**
     * 增加用户信息
     *
     * @param user 用户对象
     */
    void insertUser(User user);

    /**
     * 通过手机号查找员工编号
     * @param phoneNumber
     * @return
     */
    String selectEmployIdByPhoneNumber(String phoneNumber);

    /**
     * 通过邮箱号查找员工编号
     * @param emil
     * @return
     */
    String selectEmployIdByEmil(String emil);

    /**
     * 通过邮箱地址修改密码
     * @param user
     * @return
     */
    int updatePasswordByEmil(User user);

    /**
     * 通过手机号地址修改密码
     * @param user
     * @return
     */
    int updatePasswordByPhoneNumber(User user);
}
