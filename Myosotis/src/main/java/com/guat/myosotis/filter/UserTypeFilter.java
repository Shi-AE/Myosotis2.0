package com.guat.myosotis.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class UserTypeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //获取session
        HttpSession session = req.getSession();
        Object type = session.getAttribute("type");
        //查看用户类型
        boolean match = true;
        String servletPath = req.getServletPath();
        String[] path = servletPath.split("/");
        for (int i = 1;i < path.length;i++) {
            if (path[i].equals("user") || path[i].equals("admin")) {
                if (!path[i].equals(type)) {
                    match = false;
                }
                break;
            }
        }
        if (match) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.sendRedirect(req.getContextPath() + "/common/illegal.html");
        }
    }
}
