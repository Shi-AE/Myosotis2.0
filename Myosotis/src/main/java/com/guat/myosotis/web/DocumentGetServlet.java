package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.bean.Document;
import com.guat.myosotis.service.DocumentService;
import com.guat.myosotis.service.impl.DocumentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/document/get/servlet.do")
public class DocumentGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取员工编号
        String employId = (String) req.getSession().getAttribute("employId");
        //根据员工编号获取文件信息
        DocumentService documentService = new DocumentServiceImpl();
        List<Document> documentInfo = documentService.getDocumentInfo(employId);
        //输出
        out.write(JSON.toJSONString(documentInfo));
    }
}
