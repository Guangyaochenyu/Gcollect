package com.edu.hrbu.infoengineering.gcollect.bean;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class StuProject {
    private int stuProjectId;
    private int accountId;
    private String stuProjectNumber;
    private String stuProjectName;
    private String stuProjectLeader;
    private String stuProjectCategory;
    private String stuProjectType;
    private String stuProjectRemark;
    private int stuProjectConfirmBit;
    public StuProject(){}
    public StuProject(HashMap<String,String> mp){
        this.stuProjectId = Integer.parseInt(mp.get("stuProjectId"));
        this.accountId = Integer.parseInt(mp.get("accountId"));
        this.stuProjectNumber = mp.get("stuProjectNumber");
        this.stuProjectName = mp.get("stuProjectName");
        this.stuProjectLeader = mp.get("stuProjectLeader");
        this.stuProjectCategory = mp.get("stuProjectCategory");
        this.stuProjectType = mp.get("stuProjectType");
        this.stuProjectRemark = mp.get("stuProjectRemark");
    }
    public int getStuProjectId() {return stuProjectId;}
    public void setStuProjectId(int stuProjectId) {this.stuProjectId = stuProjectId;}
    public int getAccountId() {return accountId;}
    public void setAccountId(int accountId) {this.accountId = accountId;}
    public String getStuProjectNumber() {return stuProjectNumber;}
    public void setStuProjectNumber(String stuProjectNumber) {this.stuProjectNumber = stuProjectNumber;}
    public String getStuProjectName() {return stuProjectName;}
    public void setStuProjectName(String stuProjectName) {this.stuProjectName = stuProjectName;}
    public String getStuProjectLeader() {return stuProjectLeader;}
    public void setStuProjectLeader(String stuProjectLeader) {this.stuProjectLeader = stuProjectLeader;}
    public String getStuProjectCategory() {return stuProjectCategory;}
    public void setStuProjectCategory(String stuProjectCategory) {this.stuProjectCategory = stuProjectCategory;}
    public String getStuProjectType() {return stuProjectType;}
    public void setStuProjectType(String stuProjectType) {this.stuProjectType = stuProjectType;}
    public String getStuProjectRemark() {return stuProjectRemark;}
    public void setStuProjectRemark(String stuProjectRemark) {this.stuProjectRemark = stuProjectRemark;}
    public int getStuProjectConfirmBit() {return stuProjectConfirmBit;}
    public void setStuProjectConfirmBit(int stuProjectConfirmBit) {this.stuProjectConfirmBit = stuProjectConfirmBit;}
    @Override public String toString(){return "StuProject{"+stuProjectId+","+accountId+","+stuProjectNumber+","+stuProjectName+","+stuProjectLeader+","+stuProjectCategory+","+stuProjectType+","+stuProjectRemark+","+stuProjectConfirmBit+"}";}
    public static JSONObject translate(){
        JSONObject dict = new JSONObject(true);
        dict.put("stuProjectId","大创项目ID");
        dict.put("accountId","账号编号");
        dict.put("stuProjectNumber","项目编号");
        dict.put("stuProjectName","项目名称");
        dict.put("stuProjectLeader","项目负责人");
        dict.put("stuProjectCategory","项目类别");
        dict.put("stuProjectType","项目类型");
        dict.put("stuProjectRemark","备注");
        dict.put("stuProjectConfirmBit","确认位");
        return dict;
    }
    public JSONObject toJSON(){
        JSONObject json = new JSONObject(true);
        json.put("stuProjectId",stuProjectId);
        json.put("accountId",accountId);
        json.put("stuProjectNumber",stuProjectNumber);
        json.put("stuProjectName",stuProjectName);
        json.put("stuProjectLeader",stuProjectLeader);
        json.put("stuProjectCategory",stuProjectCategory);
        json.put("stuProjectType",stuProjectType);
        json.put("stuProjectRemark",stuProjectRemark);
        json.put("stuProjectConfirmBit",stuProjectConfirmBit);
        if(stuProjectConfirmBit==-1){
            json.put("stuProjectId",json.getString("stuProjectId")+"(已删除)");
        }
        return json;
    }
    public static JSONArray toJSON(ArrayList<StuProject> stuProjects){
        JSONArray json = new JSONArray();
        json.add(StuProject.translate());
        for(StuProject stuProject:stuProjects){json.add(stuProject.toJSON());}
        return json;
    }
}