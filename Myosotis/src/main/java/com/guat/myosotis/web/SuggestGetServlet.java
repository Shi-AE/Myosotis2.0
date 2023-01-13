package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.bean.Suggest;
import com.guat.myosotis.service.SuggestService;
import com.guat.myosotis.service.impl.SuggestServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/suggest/get/servlet.do")
public class SuggestGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取
        String employId = (String) req.getSession().getAttribute("employId");
        SuggestService suggestService = new SuggestServiceImpl();
        List<Suggest> allSuggest = suggestService.getAllSuggest(employId);
        //返回
        out.write(JSON.toJSONString(allSuggest));
    }
}
