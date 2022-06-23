package com.edu.hrbu.infoengineering.gcollect.util;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
public class Params {
    public static HashMap<String,String> get(HttpServletRequest req){
        HashMap<String,String> params = new HashMap<String,String>();
        Enumeration<String> ps = req.getParameterNames();
        while (ps.hasMoreElements()) {
            String key = ps.nextElement();
            String value = req.getParameter(key);
            params.put(key,value);
            System.out.println(key+":"+value);
        }
        return params;
    }
}
