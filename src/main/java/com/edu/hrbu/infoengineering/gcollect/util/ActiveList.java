package com.edu.hrbu.infoengineering.gcollect.util;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
public class ActiveList {
    private volatile static HashMap<String,String> instance = null;
    private static HashMap<String,String> getInstance(){
        if(instance == null){
            synchronized (ActiveList.class){
                if(instance == null){
                    instance = new HashMap<>();
                }
            }
        }
        return instance;
    }
    public static void add(String account,String sessionId){
        getInstance().put(account,sessionId);
    }
    public static void add(Account a, HttpServletRequest req){
        add(a.getAccountNumber(),req.getSession().getId());
    }
    public static Boolean isActive(HttpServletRequest req){
        try{
            String account = ((Account)req.getSession().getAttribute("account")).getAccountNumber();
            String sessionId = req.getSession().getId();
            return getInstance().get(account).equals(sessionId);
        }catch(Exception e){
            return false;
        }
    }
}