package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.bean.MyMeeting;
import com.guat.myosotis.service.MyMeetingService;
import com.guat.myosotis.service.impl.MyMeetingServiceImpl;
import com.guat.myosotis.util.StringDataUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/meeting/add/servlet.do")
public class MyMeetingAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取
        String title = req.getParameter("title");
        String startTime = req.getParameter("start-time");
        String endTime = req.getParameter("end-time");
        String note = req.getParameter("note");
        HttpSession session = req.getSession();
        String account = (String) session.getAttribute("account");
        //存入
        try {
            MyMeeting myMeeting = new MyMeeting(
                    null,
                    title,
                    StringDataUtil.stringToTimestamp(startTime),
                    StringDataUtil.stringToTime(endTime),
                    note,
                    null
            );
            MyMeetingService myMeetingService = new MyMeetingServiceImpl();
            boolean success = myMeetingService.insert(myMeeting, account);
            out.write(JSON.toJSONString(success));
        } catch (Exception e) {
            e.printStackTrace();
            out.write(JSON.toJSONString(false));
        }
    }
}
