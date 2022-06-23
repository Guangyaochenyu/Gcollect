package com.edu.hrbu.infoengineering.gcollect.test;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter("/*")
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        ServletContext sc =req.getServletContext();
        String uri = req.getRequestURI();
        if(!uri.endsWith("check") && !uri.endsWith("download") && !uri.contains("source")){System.out.println("TestFilter:"+uri);}
        chain.doFilter(request, response);
    }
}
