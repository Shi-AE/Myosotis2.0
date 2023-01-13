package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.bean.Announce;
import com.guat.myosotis.service.AnnounceService;
import com.guat.myosotis.service.impl.AnnounceServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/announce/servlet.do")
@MultipartConfig(maxFileSize = 64*1024*1024)
public class AnnounceAdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取
        boolean success = false;
        Part file = req.getPart("file");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        try {
            if (file.getSubmittedFileName() != null) {
                //存图
                String name = UUID.randomUUID() + file.getSubmittedFileName();
                String path = this.getServletContext().getRealPath("/");
                file.write(path + "/img/announce/" + name);
                //存数据库
                Announce announce = new Announce(null, title, content, name);
                AnnounceService announceService = new AnnounceServiceImpl();
                success = announceService.insertAnnounce(announce);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.write(JSON.toJSONString(success));
        }
    }
}
