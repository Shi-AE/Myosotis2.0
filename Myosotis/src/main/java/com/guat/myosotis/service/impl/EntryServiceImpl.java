package com.guat.myosotis.service.impl;

import com.guat.myosotis.bean.Admin;
import com.guat.myosotis.bean.Cipher;
import com.guat.myosotis.bean.User;
import com.guat.myosotis.dao.AdminDao;
import com.guat.myosotis.dao.UserDao;
import com.guat.myosotis.dao.impl.AdminDaoImpl;
import com.guat.myosotis.dao.impl.UserDaoImpl;
import com.guat.myosotis.exceptions.AccountErrException;
import com.guat.myosotis.exceptions.EmilErrException;
import com.guat.myosotis.exceptions.NumberErrException;
import com.guat.myosotis.service.EntryService;
import com.guat.myosotis.util.MD5;
import com.guat.myosotis.util.SqlSessionUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class EntryServiceImpl implements EntryService {
    @Override
    public boolean userVerify(String account, String password) throws EmilErrException, NumberErrException {

        Cipher cipher;
        UserDao userDao = new UserDaoImpl();
        boolean result;
        if (account.contains("@")) {
            //邮箱查询
            try {
                cipher = userDao.selectByEmil(account);
                result =  MD5.MD5Verify(password, cipher);
            } catch (NullPointerException e) {
                throw new EmilErrException();
            }
            finally {
                SqlSessionUtil.commitSqlSession();
                SqlSessionUtil.closeSqlSession();
            }
        } else {
            // 手机号查询
            try {
                cipher = userDao.selectByPhoneNumber(account);
                result =  MD5.MD5Verify(password, cipher);
            } catch (NullPointerException e) {
                throw new NumberErrException();
            } finally {
                SqlSessionUtil.commitSqlSession();
                SqlSessionUtil.closeSqlSession();
            }
        }
        return result;
    }

    @Override
    public boolean adminVerify(String account, String password) throws  AccountErrException {
        //管理员账号查询
        try {
            Cipher cipher = new AdminDaoImpl().selectByAccount(account);
            SqlSessionUtil.commitSqlSession();
            return MD5.MD5Verify(password, cipher);
        } catch (NullPointerException e) {
            throw new AccountErrException();
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
    }

    @Override
    public void creatAndSaveToken(String account, String ip, HttpServletResponse resp) {
        //生成token
        String token = MD5.MD5CreateToken(account, ip);
        //数据库查账号，存token
        UserDao userDao = new UserDaoImpl();
        try {
            if (account.contains("@")) {
                userDao.updateTokenByEmil(account, token);
                SqlSessionUtil.commitSqlSession();
            } else {
                userDao.updateTokenByPhoneNumber(account, token);
            }
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
        //token存cookie
        Cookie cookie = new Cookie("token", token);
        //保存10天
        cookie.setMaxAge(10 * 24 * 60 * 60);
        cookie.setPath("/");
        resp.addCookie(cookie);
    }

    @Override
    public String tokenVerify(String token) {
        UserDao userDao = new UserDaoImpl();
        try {
            User user = userDao.selectByToken(token);
            SqlSessionUtil.commitSqlSession();
            if (user != null) {
                String emil = user.getEmil();
                String phoneNumber = user.getPhoneNumber();
                if (emil != null)
                {
                    return emil;
                } else {
                    return phoneNumber;
                }
            }
            return null;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
    }

    @Override
    public String getEmployId(String account) {
        UserDao userDao = new UserDaoImpl();
        try {
            String employId;
            if (account.contains("@")) {
                //查邮箱
                employId = userDao.selectEmployIdByEmil(account);
            } else {
                //查手机
                employId = userDao.selectEmployIdByPhoneNumber(account);
            }
            SqlSessionUtil.commitSqlSession();
            return employId;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
    }

    @Override
    public List<Admin> getAdminList() {
        AdminDao adminDao = new AdminDaoImpl();
        try {
            List<Admin> admins = adminDao.selectAllAdmin();
            SqlSessionUtil.commitSqlSession();
            return admins;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
    }
}
