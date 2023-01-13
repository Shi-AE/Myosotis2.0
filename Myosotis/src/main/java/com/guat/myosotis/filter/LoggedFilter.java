package com.guat.myosotis.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoggedFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //获取session
        HttpSession session = req.getSession();
        Object type = session.getAttribute("type");
        if (type != null) {
            resp.sendRedirect(req.getContextPath() + "/main/" + type + "/home.html");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
