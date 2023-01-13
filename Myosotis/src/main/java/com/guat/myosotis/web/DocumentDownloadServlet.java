package com.guat.myosotis.web;

import com.guat.myosotis.service.DocumentService;
import com.guat.myosotis.service.impl.DocumentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.codec.CharEncoding;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/document/download/servlet.do")
public class DocumentDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=ISO_8859_1");
        PrintWriter out = resp.getWriter();
        //获取页面信息
        String id = req.getParameter("id");
        //通过id查找文件
        DocumentService documentService = new DocumentServiceImpl();
        byte[] file = documentService.getFile(id);
        out.write(new String(file, CharEncoding.ISO_8859_1));
    }
}
