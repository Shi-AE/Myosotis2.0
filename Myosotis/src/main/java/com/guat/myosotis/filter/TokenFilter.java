package com.guat.myosotis.filter;

import com.guat.myosotis.service.EntryService;
import com.guat.myosotis.service.impl.EntryServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {//查看token是否匹配
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //获取token
        String token = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        //与数据库中token比对,并更新
        try {
            EntryService entryService = new EntryServiceImpl();
            if (token != null) {
                //根据token查询emil
                String account = entryService.tokenVerify(token);
                if (account != null) {
                    //查员工编号
                    String employId = entryService.getEmployId(account);
                    //更新token
                    entryService.creatAndSaveToken(account, req.getRemoteAddr(), resp);
                    //绑定session
                    HttpSession session = req.getSession();
                    session.setAttribute("account", account);
                    session.setAttribute("employId",employId);
                    session.setAttribute("type", "user");
                    //重定向进入主页面
                    resp.sendRedirect(req.getContextPath() + "/main/user/home.html");
                } else {
                    // 输出异地登录信息
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                //进入登录页面
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (Exception e) {
            //未知错误
            resp.sendRedirect(req.getContextPath() + "/common/error.html");
        }
    }
}