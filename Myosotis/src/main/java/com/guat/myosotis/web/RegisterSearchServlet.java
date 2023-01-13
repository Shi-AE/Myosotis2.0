package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.json.RegisterSearchJson;
import com.guat.myosotis.service.RegisterSearchService;
import com.guat.myosotis.service.impl.RegisterSearchServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/register/search/servlet","/register/search/servlet.do"})
public class RegisterSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        try {
            RegisterSearchService registerSearchService = new RegisterSearchServiceImpl();
            RegisterSearchJson registerSearchJson = new RegisterSearchJson();
            boolean skip = true;
            if (name.equals("manager")) {
                skip = false;
                registerSearchJson.setOptions(registerSearchService.managerSearch());
            } else if (name.equals("dept")) {
                skip = false;
                registerSearchJson.setOptions(registerSearchService.deptSearch());
            }
            registerSearchJson.setSkip(skip);
            if (skip) {
                registerSearchJson.setUrl("error.html");
            }
//            System.out.println(JSON.toJSONString(registerSearchJson));
            out.write(JSON.toJSONString(registerSearchJson));
        } catch (Exception e) {
            //未知错误
            e.printStackTrace();
            out.write(
                    JSON.toJSONString(
                            new RegisterSearchJson(true, "error.html", null)
                    )
            );
        }
    }
}
