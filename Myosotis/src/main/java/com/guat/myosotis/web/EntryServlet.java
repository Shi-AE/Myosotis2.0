package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.exceptions.AccountErrException;
import com.guat.myosotis.exceptions.EmilErrException;
import com.guat.myosotis.exceptions.NumberErrException;
import com.guat.myosotis.json.EntryJson;
import com.guat.myosotis.service.EntryService;
import com.guat.myosotis.service.impl.EntryServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/user/entry/servlet", "/admin/entry/servlet"})
public class EntryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String servletPath = req.getServletPath();
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        try {
            boolean passwordIsTrue = false;
            EntryService entryService = new EntryServiceImpl();
            if (servletPath.equals("/user/entry/servlet")) {
                // 用户登录
                passwordIsTrue = entryService.userVerify(account, password);
                if (passwordIsTrue) {
                    //密码正确
                    String remember = req.getParameter("remember");
                    if (remember != null && remember.equals("remember")) {
                        //记住密码，自动登陆
                        entryService.creatAndSaveToken(account, req.getRemoteAddr(), resp);
                    }
                    //获取员工编号
                    String employId = entryService.getEmployId(account);
                    //绑定session
                    HttpSession session = req.getSession();
                    session.setAttribute("account", account);
                    session.setAttribute("employId",employId);
                    session.setAttribute("type", "user");
                    out.write(JSON.toJSONString(new EntryJson(true, null, "main/user/home.html")));
                }
            } else if (servletPath.equals("/admin/entry/servlet")) {
                // 管理员登录
                passwordIsTrue = entryService.adminVerify(account, password);
                if (passwordIsTrue) {
                    //绑定session
                    HttpSession session = req.getSession();
                    session.setAttribute("account", account);
                    session.setAttribute("type", "admin");
                    out.write(JSON.toJSONString(new EntryJson(true, null, "main/admin/home.html")));
                }
            }
            if (!passwordIsTrue) {
                //密码错误
                out.write(JSON.toJSONString(new EntryJson(false, "password", null)));
            }
        } catch (AccountErrException | NumberErrException | EmilErrException e) {
            //管理员账号错误   手机号错误   邮箱地址错误
            e.printStackTrace();
            out.write(JSON.toJSONString(new EntryJson(false, "account", null)));
        } catch (Exception e) {
            //未知错误
            e.printStackTrace();
            out.write(JSON.toJSONString(new EntryJson(true, null, "common/error.html")));
        }
    }
}
