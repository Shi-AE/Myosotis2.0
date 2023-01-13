package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.service.DocumentService;
import com.guat.myosotis.service.impl.DocumentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/document/delete/servlet.do")
public class DocumentDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取页面信息
        String id = req.getParameter("id");
        boolean success = false;
        try {
            //通过id查找文件
            DocumentService documentService = new DocumentServiceImpl();
            success = documentService.deleteFile(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.write(JSON.toJSONString(success));
        }
    }
}
