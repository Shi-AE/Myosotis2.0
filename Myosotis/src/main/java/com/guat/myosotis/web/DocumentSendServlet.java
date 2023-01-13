package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.bean.Document;
import com.guat.myosotis.service.DocumentService;
import com.guat.myosotis.service.impl.DocumentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/document/send/servlet.do")
@MultipartConfig(maxFileSize = 4 * 1024 * 1024 * 1024L)
public class DocumentSendServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取
        Part file = req.getPart("file");
        String target = req.getParameter("target");
        String note = req.getParameter("note");
        String sender = (String) req.getSession().getAttribute("employId");
        String name = file.getSubmittedFileName();
        //存入
        boolean success = false;
        try {
            if (name != null) {
                DocumentService documentService = new DocumentServiceImpl();
                byte[] bytes = documentService.getBytes(file);
                target = documentService.getTargetEmployId(target);
                Document document = new Document(null, target, bytes, name, note, sender);
                success = documentService.sendDocument(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.write(JSON.toJSONString(success));
        }
    }
}
