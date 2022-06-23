package com.edu.hrbu.infoengineering.gcollect.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter("/*")
public class PageViewFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        ServletContext sc =req.getServletContext();
        int pv = (int)sc.getAttribute("PageView");
        String uri = req.getRequestURI();
        if(!uri.endsWith("check") && !uri.endsWith("download") && !uri.contains("source")){
            sc.setAttribute("PageView",pv+1);
        }
        chain.doFilter(request, response);
    }
}