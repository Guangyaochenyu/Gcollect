package com.edu.hrbu.infoengineering.gcollect.bean;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class CopyRight {
    private int copyRightId;
    private int accountId;
    private String copyRightName;
    private String copyRightNumber;
    private String copyRightObtainTime;
    private String copyRightRemark;
    private int copyRightConfirmBit;
    public CopyRight(){}
    public CopyRight(HashMap<String,String> mp){
        this.copyRightId = Integer.parseInt(mp.get("copyRightId"));
        this.accountId = Integer.parseInt(mp.get("accountId"));
        this.copyRightName = mp.get("copyRightName");
        this.copyRightNumber = mp.get("copyRightNumber");
        this.copyRightObtainTime = mp.get("copyRightObtainTime");
        this.copyRightRemark = mp.get("copyRightRemark");
    }
    public int getCopyRightId() {return copyRightId;}
    public void setCopyRightId(int copyRightId) {this.copyRightId = copyRightId;}
    public int getAccountId() {return accountId;}
    public void setAccountId(int accountId) {this.accountId = accountId;}
    public String getCopyRightName() {return copyRightName;}
    public void setCopyRightName(String copyRightName) {this.copyRightName = copyRightName;}
    public String getCopyRightNumber() {return copyRightNumber;}
    public void setCopyRightNumber(String copyRightNumber) {this.copyRightNumber = copyRightNumber;}
    public String getCopyRightObtainTime() {return copyRightObtainTime;}
    public void setCopyRightObtainTime(String copyRightObtainTime) {this.copyRightObtainTime = copyRightObtainTime;}
    public String getCopyRightRemark() {return copyRightRemark;}
    public void setCopyRightRemark(String copyRightRemark) {this.copyRightRemark = copyRightRemark;}
    public int getCopyRightConfirmBit() {return copyRightConfirmBit;}
    public void setCopyRightConfirmBit(int copyRightConfirmBit) {this.copyRightConfirmBit = copyRightConfirmBit;}
    @Override public String toString() {return "CopyRight{"+copyRightId+","+accountId+","+copyRightName+","+copyRightNumber+","+copyRightObtainTime+","+copyRightRemark+","+copyRightConfirmBit+"}";}
    public static JSONObject translate() {
        JSONObject dict = new JSONObject(true);
        dict.put("copyRightId", "版权ID");
        dict.put("accountId", "用户ID");
        dict.put("copyRightName", "版权名称");
        dict.put("copyRightNumber", "版权编号");
        dict.put("copyRightObtainTime", "获得时间");
        dict.put("copyRightRemark", "备注");
        dict.put("copyRightConfirmBit", "确认位");
        return dict;
    }
    public JSONObject toJSON(){
        JSONObject json = new JSONObject(true);
        json.put("copyRightId",copyRightId);
        json.put("accountId",accountId);
        json.put("copyRightName",copyRightName);
        json.put("copyRightNumber",copyRightNumber);
        json.put("copyRightObtainTime",copyRightObtainTime);
        json.put("copyRightRemark",copyRightRemark);
        json.put("copyRightConfirmBit",copyRightConfirmBit);
        if(copyRightConfirmBit==-1){
            json.put("copyRightId",json.getString("copyRightId")+"(已删除)");
        }
        return json;
    }
    public static JSONArray toJSON(ArrayList<CopyRight> copyRights){
        JSONArray json = new JSONArray();
        json.add(CopyRight.translate());
        for(CopyRight copyRight:copyRights){json.add(copyRight.toJSON());}
        return json;
    }
}