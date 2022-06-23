package com.edu.hrbu.infoengineering.gcollect.servlet;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.impl.AccountImpl;
import com.edu.hrbu.infoengineering.gcollect.util.ActiveList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("path","login.jsp");
        req.getRequestDispatcher("template.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Number = req.getParameter("Number");
        String Password = req.getParameter("Password");
        System.out.println("Number: "+Number+"\tPassword: "+Password);
        Account a = new AccountImpl().query(Number);
        if(a == null || !a.getAccountPassword().equals(Password)) {
            req.setAttribute("error", "账号或密码错误");
            doGet(req,resp);
        }else{
            HttpSession session = req.getSession(true);
            session.setAttribute("account", a);
            session.setAttribute("accountList", new AccountImpl().getList(a));
            session.setAttribute("message","登录成功");
            session.setAttribute("messageType","success");
            ActiveList.add(a, req);
            resp.sendRedirect("index");
        }
    }
}