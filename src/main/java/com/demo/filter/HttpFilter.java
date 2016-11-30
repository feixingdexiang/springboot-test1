package com.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Neal.Chen on 2016/11/9.
 */
@WebFilter(filterName="httpFilter",urlPatterns="/*")
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.print("**************************in**************************");
        HttpServletResponse res = (HttpServletResponse)response;
        res.setHeader("Access-Control-Allow-Origin","*");
        res.setHeader("Access-Control-Allow-Methods","Post");
        res.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
