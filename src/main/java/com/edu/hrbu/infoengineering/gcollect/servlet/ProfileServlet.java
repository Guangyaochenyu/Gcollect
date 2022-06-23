package com.edu.hrbu.infoengineering.gcollect.servlet;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.dao.AccountDao;
import com.edu.hrbu.infoengineering.gcollect.impl.AccountImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("index","profile.jsp");
        req.setAttribute("path","index.jsp");
        req.getRequestDispatcher("template.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountDao ad = new AccountImpl();
        Account account = (Account) req.getSession().getAttribute("account");
        account.setAccountName(req.getParameter("AccountName"));
        account.setAccountPassword(req.getParameter("AccountPassword"));
        account.setAccountPid(req.getParameter("AccountPid"));
        account.setAccountDepartment(req.getParameter("AccountDepartment"));
        account.setAccountTitle(req.getParameter("AccountTitle"));
        ad.update(account);
        doGet(req,resp);
    }
}