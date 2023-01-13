package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.bean.Property;
import com.guat.myosotis.service.PropertyService;
import com.guat.myosotis.service.impl.PropertyServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/property/add/servlet.do")
public class propertyAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取
        String item = req.getParameter("item");
        String number = req.getParameter("number");
        //添加
        PropertyService propertyService = new PropertyServiceImpl();
        boolean success = false;
        try {
            success = propertyService.addProperty(new Property(null,item,Integer.parseInt(number)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.write(JSON.toJSONString(success));
        }
    }
}
