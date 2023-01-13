package com.guat.myosotis.service;

import com.guat.myosotis.bean.Employ;
import com.guat.myosotis.bean.User;

import java.util.Map;

/**
 * 注册服务
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface RegisterService {

    /**
     * 获取，封装员工信息，向数据库录入信息
     *
     * @param parameterMap 散装信息
     * @return 封装员工对象
     */
    Employ creatEmploy(Map<String, String[]> parameterMap);

    /**
     * 获取，封装用户信息，向数据库录入信息
     *
     * @param parameterMap 散装信息
     * @return 封装用户对象
     */
    User creatUser(Map<String, String[]> parameterMap, Employ employ);
}
