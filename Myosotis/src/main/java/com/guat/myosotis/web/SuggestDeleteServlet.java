package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.service.SuggestService;
import com.guat.myosotis.service.impl.SuggestServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/suggest/delete/servlet.do")
public class SuggestDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取
        String id = req.getParameter("id");
        boolean success = false;
        try {
            //删除
            SuggestService suggestService = new SuggestServiceImpl();
            success = suggestService.deleteSuggest(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //反馈
            out.write(JSON.toJSONString(success));
        }
    }
}
