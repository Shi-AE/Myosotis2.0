package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.service.AnnounceService;
import com.guat.myosotis.service.impl.AnnounceServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/announce/get/servlet.do")
public class AnnounceGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        AnnounceService announceService = null;
        try {
            //获取公告
            announceService = new AnnounceServiceImpl();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.write(JSON.toJSONString(announceService));
        }
    }
}
