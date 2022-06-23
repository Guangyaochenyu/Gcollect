package com.edu.hrbu.infoengineering.gcollect.servlet;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.impl.AccountImpl;
import com.edu.hrbu.infoengineering.gcollect.util.TemplatePost;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = (Account)req.getSession().getAttribute("account");
        if(account.getAccountAuthority()==3){
            resp.sendRedirect("index");
        }else{
            Account admin = (Account)req.getSession().getAttribute("account");
            ArrayList<Account> accounts = new AccountImpl().getList(account);
            req.setAttribute("accounts",accounts);
            req.setAttribute("index","admin.jsp");
            req.setAttribute("path","index.jsp");
            req.getRequestDispatcher("template.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplatePost.deal(req);
        doGet(req,resp);
    }
}