package com.edu.hrbu.infoengineering.gcollect.util;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
public class Dict {
    private Dict(){}
    public static volatile HashMap<String,String> instance = null;
    public static HashMap<String,String> getInstance(){
        if(instance == null){
            synchronized (Dict.class){
                if(instance == null){
                    instance = new HashMap<>();
                }
            }
        }
        return instance;
    }
    public static void put(String key,String value){
        getInstance().put(key,value);
    }
    public static String get(String key){
        return getInstance().get(key);
    }
    public static void put(JSONObject json){
        for(String key : json.keySet()){
            put(key,json.getString(key));
        }
    }
    public static JSONObject get(){
        JSONObject json = new JSONObject();
        HashMap<String,String>mp = getInstance();
        for(String key : mp.keySet()){json.put(key,mp.get(key));}
        return json;
    }
}