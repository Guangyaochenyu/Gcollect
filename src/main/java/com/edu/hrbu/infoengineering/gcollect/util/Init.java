package com.edu.hrbu.infoengineering.gcollect.util;
public class Init {
    private Init(){
        Storage.load();
        DAO.load();
        Cache.load();
    }
    private static volatile Init instance = null;
    public static void getInstance(){
        if(instance == null){
            synchronized (Init.class){
                if(instance == null){
                    instance = new Init();
                }
            }
        }
    }
}