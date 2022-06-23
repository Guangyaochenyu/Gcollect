package com.edu.hrbu.infoengineering.gcollect.test;
import com.edu.hrbu.infoengineering.gcollect.util.Gtime;
import com.edu.hrbu.infoengineering.gcollect.util.Init;
import java.util.ArrayList;
public class Test {
    public static int cnt = 0;
    public static void show(String name, ArrayList list){
        System.out.println("----------"+name+"----------");
        for(Object o : list){System.out.println(o);}
    }
    public static void test(){
        System.out.println(++cnt);
    }
    public static void main(String[] args) {
        System.out.println("Gtime:\t"+ Gtime.getInstance());
        Init.getInstance();
    }
}