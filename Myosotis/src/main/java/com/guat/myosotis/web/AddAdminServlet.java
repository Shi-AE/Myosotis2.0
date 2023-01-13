package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.bean.Admin;
import com.guat.myosotis.service.impl.HrmServiceImpl;
import com.guat.myosotis.service.HrmService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update/admin/servlet.do")
public class AddAdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        boolean success = false;
        //获取
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String contact = req.getParameter("contact");
        Admin admin = new Admin();
        admin.setHandle(account);
        admin.setContact(contact);
        //添加到数据库
        HrmService hrmService = new HrmServiceImpl();
        try {
            success = hrmService.AddAdmin(admin, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.write(JSON.toJSONString(success));
        }
    }
}
