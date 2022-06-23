package com.edu.hrbu.infoengineering.gcollect.servlet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edu.hrbu.infoengineering.gcollect.util.ActiveList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/check")
public class FakeWebSocketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JSONObject result = new JSONObject(true);
        Boolean isActive = ActiveList.isActive(req);
        result.put("isActive", isActive);
        if(!isActive){req.getSession().invalidate();}
        resp.getWriter().write(JSON.toJSONString(result));
    }
}