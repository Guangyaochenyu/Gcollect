package com.edu.hrbu.infoengineering.gcollect.bean;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class Achievement {
    private int achievementId;
    private int accountId;
    private String achievementName;
    private String achievmentLevel;
    private String achievementTime;
    private String achievementRemark;
    private int achievementConfirmBit;
    public Achievement(){}
    public Achievement(HashMap<String,String> mp){
        this.achievementId = Integer.parseInt(mp.get("achievementId"));
        this.accountId = Integer.parseInt(mp.get("accountId"));
        this.achievementName = mp.get("achievementName");
        this.achievmentLevel = mp.get("achievmentLevel");
        this.achievementTime = mp.get("achievementTime");
        this.achievementRemark = mp.get("achievementRemark");
    }
    public int getAchievementId() {return achievementId;}
    public void setAchievementId(int achievementId) {this.achievementId = achievementId;}
    public int getAccountId() {return accountId;}
    public void setAccountId(int accountId) {this.accountId = accountId;}
    public String getAchievementName() {return achievementName;}
    public void setAchievementName(String achievementName) {this.achievementName = achievementName;}
    public String getAchievmentLevel() {return achievmentLevel;}
    public void setAchievmentLevel(String achievmentLevel) {this.achievmentLevel = achievmentLevel;}
    public String getAchievementTime() {return achievementTime;}
    public void setAchievementTime(String achievementTime) {this.achievementTime = achievementTime;}
    public String getAchievementRemark() {return achievementRemark;}
    public void setAchievementRemark(String achievementRemark) {this.achievementRemark = achievementRemark;}
    public int getAchievementConfirmBit() {return achievementConfirmBit;}
    public void setAchievementConfirmBit(int achievementConfirmBit) {this.achievementConfirmBit = achievementConfirmBit;}
    @Override public String toString() {return "Achievement{"+achievementId+","+accountId+","+achievementName+","+achievmentLevel+","+achievementTime+","+achievementRemark+","+achievementConfirmBit+"}";}
    public static JSONObject translate(){
        JSONObject dict = new JSONObject(true);
        dict.put("achievementId", "成果ID");
        dict.put("accountId", "账户ID");
        dict.put("achievementName", "成果名称");
        dict.put("achievmentLevel", "成果等级");
        dict.put("achievementTime", "成果时间");
        dict.put("achievementRemark", "备注");
        dict.put("achievementConfirmBit", "确认位");
        return dict;
    }
    public JSONObject toJSON() {
        JSONObject json = new JSONObject(true);
        json.put("achievementId", achievementId);
        json.put("accountId", accountId);
        json.put("achievementName", achievementName);
        json.put("achievmentLevel", achievmentLevel);
        json.put("achievementTime", achievementTime);
        json.put("achievementRemark", achievementRemark);
        json.put("achievementConfirmBit", achievementConfirmBit);
        if(achievementConfirmBit==-1){
            json.put("achievementId",json.getString("achievementId")+"(已删除)");
        }
        return json;
    }
    public static JSONArray toJSON(ArrayList<Achievement> list) {
        JSONArray json = new JSONArray();
        json.add(Achievement.translate());
        for (Achievement achievement : list) {json.add(achievement.toJSON());}
        return json;
    }
}