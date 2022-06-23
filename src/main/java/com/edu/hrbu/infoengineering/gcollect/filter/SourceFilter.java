package com.edu.hrbu.infoengineering.gcollect.filter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.util.ActiveList;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebFilter("/*")
public class SourceFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        if(ActiveList.isActive(req) && !uri.endsWith("check")){
            ArrayList<String> k = new ArrayList<>();
            ArrayList<String> v = new ArrayList<>();
            Account account = (Account)req.getSession().getAttribute("account");
            k.add("profile");v.add("个人信息");
            if (account.getAccountAuthority() != 3) {k.add("admin");v.add("账号列表");}
            k.add("paper");v.add("论文列表");
            k.add("book");v.add("图书列表");
            k.add("project");v.add("项目列表");
            k.add("patent");v.add("专利列表");
            k.add("copyright");v.add("软件著作权列表");
            k.add("achievement");v.add("成果奖励列表");
            k.add("stuproject");v.add("大创项目列表");
            req.setAttribute("k",k);
            req.setAttribute("v",v);
        }
        chain.doFilter(request, response);
    }
}