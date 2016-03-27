package com.ams.filter;

import com.ams.entities.admin.UserInfo;
import com.ams.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evan on 2016/3/21.
 */
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest requestHttp = (HttpServletRequest) request;
        String requestURI = requestHttp.getRequestURI().toLowerCase();
        HttpServletResponse responseHttp = (HttpServletResponse) response;
        // 判断是否是首次登陆
        boolean isLogin = requestURI.indexOf("login") >= 0 || requestURI.indexOf("admin/index.do") >= 0;
        UserInfo loginUser = (UserInfo) requestHttp.getSession().getAttribute(Constant.SESSION_LOGIN_USER);
        if (!isLogin && loginUser == null) {
            //如果判断是 AJAX 请求,直接设置为session超时
            if (requestHttp.getHeader("x-requested-with") != null && requestHttp.getHeader("x-requested-with").equals("XMLHttpRequest")) {
                responseHttp.setHeader("sessionstatus", "timeout");
            } else {
                request.setAttribute("message", "登陆超时，请重新登陆！");
                StringBuffer redirectUrl = new StringBuffer();
                redirectUrl.append(requestHttp.getScheme()).append("://");
                redirectUrl.append(requestHttp.getServerName()).append(":");
                redirectUrl.append(requestHttp.getServerPort()).append(requestHttp.getContextPath());
                redirectUrl.append("/admin/index.do");
                ((HttpServletResponse) response).sendRedirect(redirectUrl.toString());
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
