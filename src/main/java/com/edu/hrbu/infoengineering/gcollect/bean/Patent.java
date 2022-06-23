package com.edu.hrbu.infoengineering.gcollect.bean;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class Patent {
    private int patentId;
    private int accountId;
    private String patentName;
    private String patentNumber;
    private String patentType;
    private String patentFilingTime;
    private String patentAcquisitionTime;
    private String patentRole;
    private String patentAwardName;
    private String patentAwardLevel;
    private String patentAwardTime;
    private String patentAwardUnit;
    private String patentRemark;
    private int patentConfirmBit;
    public Patent(){}
    public Patent(HashMap<String,String> mp) {
        this.patentId = Integer.parseInt(mp.get("patentId"));
        this.accountId = Integer.parseInt(mp.get("accountId"));
        this.patentName = mp.get("patentName");
        this.patentNumber = mp.get("patentNumber");
        this.patentType = mp.get("patentType");
        this.patentFilingTime = mp.get("patentFilingTime");
        this.patentAcquisitionTime = mp.get("patentAcquisitionTime");
        this.patentRole = mp.get("patentRole");
        this.patentAwardName = mp.get("patentAwardName");
        this.patentAwardLevel = mp.get("patentAwardLevel");
        this.patentAwardTime = mp.get("patentAwardTime");
        this.patentAwardUnit = mp.get("patentAwardUnit");
        this.patentRemark = mp.get("patentRemark");
    }
    public int getPatentId() {return patentId;}
    public void setPatentId(int patentId) {this.patentId = patentId;}
    public int getAccountId() {return accountId;}
    public void setAccountId(int accountId) {this.accountId = accountId;}
    public String getPatentName() {return patentName;}
    public void setPatentName(String patentName) {this.patentName = patentName;}
    public String getPatentNumber() {return patentNumber;}
    public void setPatentNumber(String patentNumber) {this.patentNumber = patentNumber;}
    public String getPatentType() {return patentType;}
    public void setPatentType(String patentType) {this.patentType = patentType;}
    public String getPatentFilingTime() {return patentFilingTime;}
    public void setPatentFilingTime(String patentFilingTime) {this.patentFilingTime = patentFilingTime;}
    public String getPatentAcquisitionTime() {return patentAcquisitionTime;}
    public void setPatentAcquisitionTime(String patentAcquisitionTime) {this.patentAcquisitionTime = patentAcquisitionTime;}
    public String getPatentRole() {return patentRole;}
    public void setPatentRole(String patentRole) {this.patentRole = patentRole;}
    public String getPatentAwardName() {return patentAwardName;}
    public void setPatentAwardName(String patentAwardName) {this.patentAwardName = patentAwardName;}
    public String getPatentAwardLevel() {return patentAwardLevel;}
    public void setPatentAwardLevel(String patentAwardLevel) {this.patentAwardLevel = patentAwardLevel;}
    public String getPatentAwardTime() {return patentAwardTime;}
    public void setPatentAwardTime(String patentAwardTime) {this.patentAwardTime = patentAwardTime;}
    public String getPatentAwardUnit() {return patentAwardUnit;}
    public void setPatentAwardUnit(String patentAwardUnit) {this.patentAwardUnit = patentAwardUnit;}
    public String getPatentRemark() {return patentRemark;}
    public void setPatentRemark(String patentRemark) {this.patentRemark = patentRemark;}
    public int getPatentConfirmBit() {return patentConfirmBit;}
    public void setPatentConfirmBit(int patentConfirmBit) {this.patentConfirmBit = patentConfirmBit;}
    @Override public String toString() {return "Patent{"+patentId+","+accountId+","+patentName+","+patentNumber+","+patentType+","+patentFilingTime+","+patentAcquisitionTime+","+patentRole+","+patentAwardName+","+patentAwardLevel+","+patentAwardTime+","+patentAwardUnit+","+patentRemark+","+patentConfirmBit+"}";}
    public static JSONObject translate(){
        JSONObject dict = new JSONObject(true);
        dict.put("patentId","专利ID");
        dict.put("accountId","账户ID");
        dict.put("patentName","专利名称");
        dict.put("patentNumber","专利号");
        dict.put("patentType","专利类型");
        dict.put("patentFilingTime","登记时间");
        dict.put("patentAcquisitionTime","获得时间");
        dict.put("patentRole","角色");
        dict.put("patentAwardName","奖项名称");
        dict.put("patentAwardLevel","奖项级别");
        dict.put("patentAwardTime","奖项时间");
        dict.put("patentAwardUnit","奖项单位");
        dict.put("patentRemark","备注");
        dict.put("patentConfirmBit","确认位");
        return dict;
    }
    public JSONObject toJSON(){
        JSONObject json = new JSONObject(true);
        json.put("patentId",patentId);
        json.put("accountId",accountId);
        json.put("patentName",patentName);
        json.put("patentNumber",patentNumber);
        json.put("patentType",patentType);
        json.put("patentFilingTime",patentFilingTime);
        json.put("patentAcquisitionTime",patentAcquisitionTime);
        json.put("patentRole",patentRole);
        json.put("patentAwardName",patentAwardName);
        json.put("patentAwardLevel",patentAwardLevel);
        json.put("patentAwardTime",patentAwardTime);
        json.put("patentAwardUnit",patentAwardUnit);
        json.put("patentRemark",patentRemark);
        json.put("patentConfirmBit",patentConfirmBit);
        if(patentConfirmBit==-1){
            json.put("patentId",json.getString("patentId")+"(已删除)");
        }
        return json;
    }
    public static JSONArray toJSON(ArrayList<Patent> patents){
        JSONArray json = new JSONArray();
        json.add(Patent.translate());
        for(Patent patent:patents){json.add(patent.toJSON());}
        return json;
    }
}