package com.edu.hrbu.infoengineering.gcollect.util;
import com.alibaba.fastjson.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DAO {
    private static String DRIVER = null;
    private static String URL = null;
    private static String USER = null;
    private static String PASSWORD = null;
    public static void load(){
        DRIVER = Storage.get("DAO","DRIVER");
        URL = Storage.get("DAO","URL");
        USER = Storage.get("DAO","USER");
        PASSWORD = Storage.get("DAO","PASSWORD");
    }
    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        try{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<String> show(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> list;
        try{
            conn = DAO.getConnection();
            String sql = "show tables";
            assert conn != null;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                list.add(rs.getString(1));
            }
            return list;
        }catch(Exception e){
            return new ArrayList<>();
        }finally{
            DAO.close(conn,ps,rs);
        }
    }
    public static JSONObject desc(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        JSONObject jsons = new JSONObject(true);
        try{
            conn = DAO.getConnection();
            assert conn != null;
            for(String table : DAO.show()){
//                String sql = "desc ?";
                String sql = "desc " + table;
                ps = conn.prepareStatement(sql);
//                ps.setString(1,table);
                rs = ps.executeQuery();
                JSONObject json = new JSONObject(true);
                ArrayList<String> NotNull = new ArrayList<>();
                ArrayList<String> Key = new ArrayList<>();
                while(rs.next()){
                    String Field = rs.getString(1);
                    if(rs.getString(3).equals("NO")){NotNull.add(Field);}
                    if(rs.getString(4).equals("UNI")){Key.add(Field);}
                }
                json.put("NotNull",NotNull);
                json.put("Key",Key);
                jsons.put(table,json);
            }
            return jsons;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return new JSONObject(true);
        }finally{
            DAO.close(conn,ps,rs);
        }
    }
}