package com.edu.hrbu.infoengineering.gcollect.servlet;
import com.edu.hrbu.infoengineering.gcollect.util.TemplatePost;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("index","book.jsp");
        req.setAttribute("path","index.jsp");
        req.getRequestDispatcher("template.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplatePost.deal(req);
        doGet(req,resp);
    }
}