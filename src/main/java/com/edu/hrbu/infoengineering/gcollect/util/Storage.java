package com.edu.hrbu.infoengineering.gcollect.util;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;
public class Storage {
    private Storage(){}
    private static volatile HashMap<String, Properties> instance = null;
    public static HashMap<String,Properties> getInstance(){
        if(instance == null){
            synchronized (Storage.class){
                if(instance == null){
                    instance = new HashMap<>();
                }
            }
        }
        return instance;
    }
    public static void fload(String pname){
        Properties prop =new Properties();
        try{
            InputStream in = new BufferedInputStream(Files.newInputStream(Paths.get(pname + ".properties")));
            prop.load(in);
            Storage.getInstance().put(pname,prop);
            in.close();
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void load(){
        Storage.fload("gprop");
        for(int i=Integer.parseInt(Storage.getInstance().get("gprop").getProperty("size"));i>0;i--){
            Storage.fload(Storage.getInstance().get("gprop").getProperty("prop"+i));
        }
    }
    public static String get(String pname,String key){
        Properties prop = Storage.getInstance().get(pname);
        if(prop == null){return null;}
        return prop.getProperty(key);
    }
    public static void show(){
        for(String key : Storage.getInstance().keySet()){
            System.out.println(key+":");
            for(String k : Storage.getInstance().get(key).stringPropertyNames()){
                System.out.println(k+":"+Storage.getInstance().get(key).getProperty(k));
            }
        }
    }
}