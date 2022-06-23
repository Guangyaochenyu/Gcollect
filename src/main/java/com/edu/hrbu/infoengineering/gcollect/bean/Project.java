package com.edu.hrbu.infoengineering.gcollect.bean;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class Project {
    private int projectId;
    private int accountId;
    private String projectName;
    private String projectSource;
    private String projectNumber;
    private String projectStartTime;
    private String projectEndTime;
    private int projectFund;
    private String projectAwardName;
    private String projectAwardLevel;
    private String projectAwardTime;
    private String projectAwardUnit;
    private String projectRemark;
    private int projectConfirmBit;
    public Project(){}
    public Project(HashMap<String,String> mp) {
        this.projectId = Integer.parseInt(mp.get("projectId"));
        this.accountId = Integer.parseInt(mp.get("accountId"));
        this.projectName = mp.get("projectName");
        this.projectSource = mp.get("projectSource");
        this.projectNumber = mp.get("projectNumber");
        this.projectStartTime = mp.get("projectStartTime");
        this.projectEndTime = mp.get("projectEndTime");
        this.projectFund = Integer.parseInt(mp.get("projectFund"));
        this.projectAwardName = mp.get("projectAwardName");
        this.projectAwardLevel = mp.get("projectAwardLevel");
        this.projectAwardTime = mp.get("projectAwardTime");
        this.projectAwardUnit = mp.get("projectAwardUnit");
        this.projectRemark = mp.get("projectRemark");
    }
    public int getProjectId() {return projectId;}
    public void setProjectId(int projectId) {this.projectId = projectId;}
    public int getAccountId() {return accountId;}
    public void setAccountId(int accountId) {this.accountId = accountId;}
    public String getProjectName() {return projectName;}
    public void setProjectName(String projectName) {this.projectName = projectName;}
    public String getProjectSource() {return projectSource;}
    public void setProjectSource(String projectSource) {this.projectSource = projectSource;}
    public String getProjectNumber() {return projectNumber;}
    public void setProjectNumber(String projectNumber) {this.projectNumber = projectNumber;}
    public String getProjectStartTime() {return projectStartTime;}
    public void setProjectStartTime(String projectStartTime) {this.projectStartTime = projectStartTime;}
    public String getProjectEndTime() {return projectEndTime;}
    public void setProjectEndTime(String projectEndTime) {this.projectEndTime = projectEndTime;}
    public int getProjectFund() {return projectFund;}
    public void setProjectFund(int projectFund) {this.projectFund = projectFund;}
    public String getProjectAwardName() {return projectAwardName;}
    public void setProjectAwardName(String projectAwardName) {this.projectAwardName = projectAwardName;}
    public String getProjectAwardLevel() {return projectAwardLevel;}
    public void setProjectAwardLevel(String projectAwardLevel) {this.projectAwardLevel = projectAwardLevel;}
    public String getProjectAwardTime() {return projectAwardTime;}
    public void setProjectAwardTime(String projectAwardTime) {this.projectAwardTime = projectAwardTime;}
    public String getProjectAwardUnit() {return projectAwardUnit;}
    public void setProjectAwardUnit(String projectAwardUnit) {this.projectAwardUnit = projectAwardUnit;}
    public String getProjectRemark() {return projectRemark;}
    public void setProjectRemark(String projectRemark) {this.projectRemark = projectRemark;}
    public int getProjectConfirmBit() {return projectConfirmBit;}
    public void setProjectConfirmBit(int projectConfirmBit) {this.projectConfirmBit = projectConfirmBit;}
    @Override public String toString(){return "Project{"+projectId+","+accountId+","+projectName+","+projectSource+","+projectNumber+","+projectStartTime+","+projectEndTime+","+projectFund+","+projectAwardName+","+projectAwardLevel+","+projectAwardTime+","+projectAwardUnit+","+projectRemark+","+projectConfirmBit+"}";}
    public static JSONObject translate(){
        JSONObject dict = new JSONObject(true);
        dict.put("projectId", "项目ID");
        dict.put("accountId", "账户ID");
        dict.put("projectName", "名称");
        dict.put("projectSource", "来源");
        dict.put("projectNumber", "项目编号");
        dict.put("projectStartTime", "开始时间");
        dict.put("projectEndTime", "结束时间");
        dict.put("projectFund", "项目经费");
        dict.put("projectAwardName", "获奖名称");
        dict.put("projectAwardLevel", "获奖等级");
        dict.put("projectAwardTime", "获奖时间");
        dict.put("projectAwardUnit", "获奖单位");
        dict.put("projectRemark", "备注");
        dict.put("projectConfirmBit", "确认位");
        return dict;
    }
    public JSONObject toJSON(){
        JSONObject json = new JSONObject(true);
        json.put("projectId", projectId);
        json.put("accountId", accountId);
        json.put("projectName", projectName);
        json.put("projectSource", projectSource);
        json.put("projectNumber", projectNumber);
        json.put("projectStartTime", projectStartTime);
        json.put("projectEndTime", projectEndTime);
        json.put("projectFund", projectFund);
        json.put("projectAwardName", projectAwardName);
        json.put("projectAwardLevel", projectAwardLevel);
        json.put("projectAwardTime", projectAwardTime);
        json.put("projectAwardUnit", projectAwardUnit);
        json.put("projectRemark", projectRemark);
        json.put("projectConfirmBit", projectConfirmBit);
        if(projectConfirmBit==-1){
            json.put("projectId",json.getString("projectId")+"(已删除)");
        }
        return json;
    }
    public static JSONArray toJSON(ArrayList<Project> projects){
        JSONArray json = new JSONArray();
        json.add(Project.translate());
        for(Project project:projects){json.add(project.toJSON());}
        return json;
    }
}