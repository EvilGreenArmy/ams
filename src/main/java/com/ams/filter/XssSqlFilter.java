package com.ams.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Xss跨站攻击 & Sql 注入  过滤.
 * Created by Evan on 2016/3/18.
 */
public class XssSqlFilter implements Filter {
    protected String charset = "utf-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (request.getMethod().equalsIgnoreCase("post")) {//如果是post请求
            chain.doFilter(new XssSqlHtmlRequestWrapper((HttpServletRequest) request), response);
        } else {
            //如果是Get请求
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
