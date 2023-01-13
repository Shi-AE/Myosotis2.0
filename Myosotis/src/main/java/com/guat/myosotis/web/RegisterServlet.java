package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.bean.Employ;
import com.guat.myosotis.json.EntryJson;
import com.guat.myosotis.json.RegisterFormJson;
import com.guat.myosotis.service.RegisterService;
import com.guat.myosotis.service.impl.RegisterServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/register/servlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Map<String, String[]> parameterMap = req.getParameterMap();
//        String name = req.getParameter("name");
//        String job = req.getParameter("job");
//        String deptName = req.getParameter("dept");
//        String manager = req.getParameter("manager");
//        String date = req.getParameter("date");
//        String number = req.getParameter("number");
//        String emil = req.getParameter("emil");
//        String password = req.getParameter("password");
//        String confirmPassword = req.getParameter("confirm-password");
        try {
            boolean passVerify = true;
            RegisterFormJson registerFormJson = new RegisterFormJson();
            //判断是否存在空值
            for (String name : parameterMap.keySet()) {
                String value = parameterMap.get(name)[0];
                if (!name.equals("emil") && !name.equals("number") && value.equals("")) {
                    passVerify = false;
                    registerFormJson.addError(name);
                }
            }
            if (passVerify) {
                if (parameterMap.get("password")[0].equals(parameterMap.get("confirm-password")[0])) {
                    //封装信息
                    //向数据库录入信息
                    RegisterService registerService = new RegisterServiceImpl();
                    //获取员工信息对象
                    Employ employ = registerService.creatEmploy(parameterMap);
                    //获取用户对象
                    registerService.creatUser(parameterMap, employ);
                    //跳转登录页面
                    out.write(JSON.toJSONString(new RegisterFormJson(true, null, "../")));
                } else {
                    //确认密码错误
                    registerFormJson.addError("confirm-password");
                    registerFormJson.setSkip(false);
                    out.write(JSON.toJSONString(registerFormJson));
                }
            } else {
                //必填表存在空值
                registerFormJson.setSkip(false);
                out.write(JSON.toJSONString(registerFormJson));
            }
        } catch (Exception e) {
            //未知错误
            e.printStackTrace();
            out.write(JSON.toJSONString(new EntryJson(true, null, "error.html")));
        }
    }
}
