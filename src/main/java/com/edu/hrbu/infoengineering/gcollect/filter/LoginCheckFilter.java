package com.edu.hrbu.infoengineering.gcollect.filter;
import com.edu.hrbu.infoengineering.gcollect.util.ActiveList;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        Boolean isActive = ActiveList.isActive(req);
        Boolean isLogin = uri.endsWith("login");
        boolean isSource = uri.contains("source");
        if(uri.endsWith("check"))chain.doFilter(request, response);
        else if(isSource)chain.doFilter(request, response);
        else if(!isActive && !isLogin) {resp.sendRedirect("login");}
        else if(isActive && isLogin){resp.sendRedirect("index");}
        else chain.doFilter(request, response);
    }
}