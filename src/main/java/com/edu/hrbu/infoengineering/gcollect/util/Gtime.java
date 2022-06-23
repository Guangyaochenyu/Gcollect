package com.edu.hrbu.infoengineering.gcollect.util;
import java.sql.Date;
import java.sql.Time;
public class Gtime {
    private static volatile Gtime instance = null;
    private Gtime(){}
    public static Gtime getInstance(){
        if(instance == null){
            synchronized (Gtime.class){
                if(instance == null){
                    instance = new Gtime();
                }
            }
        }
        return instance;
    }
    public String toString(){
        long now = System.currentTimeMillis();
        return new Date(now).toString()+" "+new Time(now).toString();
    }
}