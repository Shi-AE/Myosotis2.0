package com.guat.myosotis.service.impl;

import com.guat.myosotis.bean.Cipher;
import com.guat.myosotis.bean.Employ;
import com.guat.myosotis.bean.User;
import com.guat.myosotis.dao.DeptDao;
import com.guat.myosotis.dao.EmployDao;
import com.guat.myosotis.dao.UserDao;
import com.guat.myosotis.dao.impl.DeptDaoImpl;
import com.guat.myosotis.dao.impl.EmployDaoImpl;
import com.guat.myosotis.dao.impl.UserDaoImpl;
import com.guat.myosotis.service.RegisterService;
import com.guat.myosotis.util.EmployIdUtil;
import com.guat.myosotis.util.MD5;
import com.guat.myosotis.util.SqlSessionUtil;

import java.util.Map;

public class RegisterServiceImpl implements RegisterService {

    @Override
    public Employ creatEmploy(Map<String, String[]> parameterMap) {
        Employ employ = new Employ();
        EmployDao employDao = new EmployDaoImpl();
        DeptDao deptDao = new DeptDaoImpl();
        //获取上级领导编号
        String managerId = employDao.selectEmployIdByName(parameterMap.get("manager")[0]);
        employ.setManagerId(managerId);
        //获取部门编号
        String deptId = deptDao.selectDeptIdByName(parameterMap.get("dept")[0]);
        employ.setDeptId(deptId);
        //添加信息
        employ.setHireDate(parameterMap.get("date")[0]);
        employ.setJob(parameterMap.get("job")[0]);
        employ.setName(parameterMap.get("name")[0]);
        //制作员工编号
        employ.setEmployId(EmployIdUtil.stringify(employ));
        //录入数据库
        employDao.insertEmploy(employ);
        return employ;
    }

    @Override
    public User creatUser(Map<String, String[]> parameterMap, Employ employ) {
        //封装
        User user = new User();
        user.setPhoneNumber(parameterMap.get("number")[0]);
        user.setEmil(parameterMap.get("emil")[0]);
        user.setEmployId(employ.getEmployId());
        Cipher cipher = MD5.MD5AddSalt(parameterMap.get("password")[0]);
        user.setCipherText(cipher.getCipherText());
        user.setSalt(cipher.getSalt());
        //录入数据库
        UserDao userDao = new UserDaoImpl();
        try {
            userDao.insertUser(user);
            SqlSessionUtil.commitSqlSession();
            return user;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
    }
}
