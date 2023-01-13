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

@WebServlet("/announce/delete/servlet.do")
public class AnnounceDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        AnnounceService announceService = new AnnounceServiceImpl();
        //获取
        String path = this.getServletContext().getRealPath("/");
        String id = req.getParameter("id");
        boolean success = false;
        try {
            //删除
            success = announceService.deleteAnnounce(id, path);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //返回
            out.write(JSON.toJSONString(success));
        }


    }
}
