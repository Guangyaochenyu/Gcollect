package com.edu.hrbu.infoengineering.gcollect.servlet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edu.hrbu.infoengineering.gcollect.bean.*;
import com.edu.hrbu.infoengineering.gcollect.impl.*;
import com.edu.hrbu.infoengineering.gcollect.util.DAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        JSONObject json = new JSONObject(true);
        ArrayList<String> SheetNames = new ArrayList<>();
        JSONObject Sheets = new JSONObject(true);
        Account account = (Account)req.getSession().getAttribute("account");
        ArrayList<String> k = (ArrayList<String>)req.getAttribute("k");
        ArrayList<String> v = (ArrayList<String>)req.getAttribute("v");
        HashMap<String,String> kv = new HashMap<>();
        for(int i=0;i<k.size();i++){kv.put(k.get(i),v.get(i));}
        ArrayList<String> o = new ArrayList<>();
        HashMap<String,JSONArray> s = new HashMap<>();
        if(account.getAccountAuthority()!=3){
            o.add("admin");
            s.put("admin",Account.toJSON(new AccountImpl().getList(account)));
        }
        o.add("paper");
        s.put("paper", Paper.toJSON(new PaperImpl().getList(account)));
        o.add("book");
        s.put("book", Book.toJSON(new BookImpl().getList(account)));
        o.add("project");
        s.put("project", Project.toJSON(new ProjectImpl().getList(account)));
        o.add("patent");
        s.put("patent",Patent.toJSON(new PatentImpl().getList(account)));
        o.add("copyright");
        s.put("copyright",CopyRight.toJSON(new CopyRightImpl().getList(account)));
        o.add("achievement");
        s.put("achievement",Achievement.toJSON(new AchievementImpl().getList(account)));
        o.add("stuproject");
        s.put("stuproject",StuProject.toJSON(new StuProjectImpl().getList(account)));
        for(String sheetname:o) {
            SheetNames.add(kv.get(sheetname));
            Sheets.put(kv.get(sheetname),s.get(sheetname));
        }
        json.put("SheetNames",SheetNames);
        json.put("Sheets",Sheets);
        json.put("rule", DAO.desc());
        resp.getWriter().println(JSON.toJSONString(json));
    }
}
