package com.edu.hrbu.infoengineering.gcollect.bean;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class Paper {
    private int paperId;
    private int accountId;
    private String paperName;
    private String paperSource;
    private String paperPublishTime;
    private String paperCategory;
    private String paperRole;
    private String paperAchieveType;
    private String paperAchieveLevel;
    private String paperAwardName;
    private String paperAwardLevel;
    private String paperAwardTime;
    private String paperAwardUnit;
    private String paperRemark;
    private int paperConfirmBit;
    public Paper(){}
    public Paper(HashMap<String,String> mp) {
        this.paperId = Integer.parseInt(mp.get("paperId"));
        this.accountId = Integer.parseInt(mp.get("accountId"));
        this.paperName = mp.get("paperName");
        this.paperSource = mp.get("paperSource");
        this.paperPublishTime = mp.get("paperPublishTime");
        this.paperCategory = mp.get("paperCategory");
        this.paperRole = mp.get("paperRole");
        this.paperAchieveType = mp.get("paperAchieveType");
        this.paperAchieveLevel = mp.get("paperAchieveLevel");
        this.paperAwardName = mp.get("paperAwardName");
        this.paperAwardLevel = mp.get("paperAwardLevel");
        this.paperAwardTime = mp.get("paperAwardTime");
        this.paperAwardUnit = mp.get("paperAwardUnit");
        this.paperRemark = mp.get("paperRemark");
    }
    public int getPaperId() {return paperId;}
    public void setPaperId(int paperId) {this.paperId = paperId;}
    public int getAccountId() {return accountId;}
    public void setAccountId(int accountId) {this.accountId = accountId;}
    public String getPaperName() {return paperName;}
    public void setPaperName(String paperName) {this.paperName = paperName;}
    public String getPaperSource() {return paperSource;}
    public void setPaperSource(String paperSource) {this.paperSource = paperSource;}
    public String getPaperPublishTime() {return paperPublishTime;}
    public void setPaperPublishTime(String paperPublishTime) {this.paperPublishTime = paperPublishTime;}
    public String getPaperCategory() {return paperCategory;}
    public void setPaperCategory(String paperCategory) {this.paperCategory = paperCategory;}
    public String getPaperRole() {return paperRole;}
    public void setPaperRole(String paperRole) {this.paperRole = paperRole;}
    public String getPaperAchieveType() {return paperAchieveType;}
    public void setPaperAchieveType(String paperAchieveType) {this.paperAchieveType = paperAchieveType;}
    public String getPaperAchieveLevel() {return paperAchieveLevel;}
    public void setPaperAchieveLevel(String paperAchieveLevel) {this.paperAchieveLevel = paperAchieveLevel;}
    public String getPaperAwardName() {return paperAwardName;}
    public void setPaperAwardName(String paperAwardName) {this.paperAwardName = paperAwardName;}
    public String getPaperAwardLevel() {return paperAwardLevel;}
    public void setPaperAwardLevel(String paperAwardLevel) {this.paperAwardLevel = paperAwardLevel;}
    public String getPaperAwardTime() {return paperAwardTime;}
    public void setPaperAwardTime(String paperAwardTime) {this.paperAwardTime = paperAwardTime;}
    public String getPaperAwardUnit() {return paperAwardUnit;}
    public void setPaperAwardUnit(String paperAwardUnit) {this.paperAwardUnit = paperAwardUnit;}
    public String getPaperRemark() {return paperRemark;}
    public void setPaperRemark(String paperRemark) {this.paperRemark = paperRemark;}
    public int getPaperConfirmBit() {return paperConfirmBit;}
    public void setPaperConfirmBit(int paperConfirmBit) {this.paperConfirmBit = paperConfirmBit;}
    @Override public String toString() {return "Paper{"+paperId+","+accountId+","+paperName+","+paperSource+","+paperPublishTime+","+paperCategory+","+paperRole+","+paperAchieveType+","+paperAchieveLevel+","+paperAwardName+","+paperAwardLevel+","+paperAwardTime+","+paperAwardUnit+","+paperRemark+","+paperConfirmBit+"}";}
    public static JSONObject translate(){
        JSONObject dict = new JSONObject(true);
        dict.put("paperId", "??????ID");
        dict.put("accountId", "??????ID");
        dict.put("paperName", "??????");
        dict.put("paperSource", "??????");
        dict.put("paperPublishTime", "????????????");
        dict.put("paperCategory", "??????");
        dict.put("paperRole", "??????");
        dict.put("paperAchieveType", "????????????");
        dict.put("paperAchieveLevel", "????????????");
        dict.put("paperAwardName", "????????????");
        dict.put("paperAwardLevel", "????????????");
        dict.put("paperAwardTime", "????????????");
        dict.put("paperAwardUnit", "????????????");
        dict.put("paperRemark", "??????");
        dict.put("paperConfirmBit", "?????????");
        return dict;
    }
    public JSONObject toJSON(){
        JSONObject json = new JSONObject(true);
        json.put("paperId", paperId);
        json.put("accountId", accountId);
        json.put("paperName", paperName);
        json.put("paperSource", paperSource);
        json.put("paperPublishTime", paperPublishTime);
        json.put("paperCategory", paperCategory);
        json.put("paperRole", paperRole);
        json.put("paperAchieveType", paperAchieveType);
        json.put("paperAchieveLevel", paperAchieveLevel);
        json.put("paperAwardName", paperAwardName);
        json.put("paperAwardLevel", paperAwardLevel);
        json.put("paperAwardTime", paperAwardTime);
        json.put("paperAwardUnit", paperAwardUnit);
        json.put("paperRemark", paperRemark);
        json.put("paperConfirmBit", paperConfirmBit);
        if(paperConfirmBit==-1){
            json.put("paperId",json.getString("paperId")+"(?????????)");
        }
        return json;
    }
    public static JSONArray toJSON(ArrayList<Paper> papers){
        JSONArray json = new JSONArray();
        json.add(Paper.translate());
        for(Paper paper:papers){json.add(paper.toJSON());}
        return json;
    }
}