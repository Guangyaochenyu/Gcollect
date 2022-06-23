package com.edu.hrbu.infoengineering.gcollect.bean;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class Account {
    private int accountId;
    private String accountNumber;
    private String accountPassword;
    private String accountName;
    private int accountAuthority;// 0: 全部 1: 有效 2: 部门 3: 自己
    private String accountPid;
    private String accountDepartment;
    private String accountTitle;
    private int accountConfirmBit;
    public Account() {}
    public Account(HashMap<String,String> mp){
        this.accountId = Integer.parseInt(mp.get("accountId"));
        this.accountNumber = mp.get("accountNumber");
        this.accountPassword = mp.get("accountPassword");
        this.accountName = mp.get("accountName");
        this.accountAuthority = Integer.parseInt(mp.get("accountAuthority"));
        this.accountPid = mp.get("accountPid");
        this.accountDepartment = mp.get("accountDepartment");
        this.accountTitle = mp.get("accountTitle");
    }
    public int getAccountId() {return accountId;}
    public void setAccountId(int accountId) {this.accountId = accountId;}
    public String getAccountNumber() {return accountNumber;}
    public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}
    public String getAccountPassword() {return accountPassword;}
    public void setAccountPassword(String accountPassword) {this.accountPassword = accountPassword;}
    public String getAccountName() {return accountName;}
    public void setAccountName(String accountName) {this.accountName = accountName;}
    public int getAccountAuthority() {return accountAuthority;}
    public void setAccountAuthority(int accountAuthority) {this.accountAuthority = accountAuthority;}
    public String getAccountPid() {return accountPid;}
    public void setAccountPid(String accountPid) {this.accountPid = accountPid;}
    public String getAccountDepartment() {return accountDepartment;}
    public void setAccountDepartment(String accountDepartment) {this.accountDepartment = accountDepartment;}
    public String getAccountTitle() {return accountTitle;}
    public void setAccountTitle(String accountTitle) {this.accountTitle = accountTitle;}
    public int getAccountConfirmBit() {return accountConfirmBit;}
    public void setAccountConfirmBit(int accountConfirmBit) {this.accountConfirmBit = accountConfirmBit;}
    @Override public String toString() {return "Account{" + accountId + "," + accountNumber + "," + accountName + "," + accountPassword + "," + accountAuthority + "," + accountPid + "," + accountDepartment + "," + accountTitle + "," + accountConfirmBit + "}";}
    public static JSONObject translate() {
        JSONObject dict = new JSONObject(true);
        dict.put("accountId", "账户ID");
        dict.put("accountNumber", "工号");
        dict.put("accountPassword", "密码");
        dict.put("accountName", "姓名");
        dict.put("accountAuthority", "权限");
        dict.put("accountPid", "身份证号");
        dict.put("accountDepartment", "部门");
        dict.put("accountTitle", "职称");
        dict.put("accountConfirmBit", "确认位");
        return dict;
    }
    public JSONObject toJSON(){
        JSONObject json = new JSONObject(true);
        json.put("accountId", accountId);
        json.put("accountNumber", accountNumber);
        json.put("accountPassword", accountPassword);
        json.put("accountName", accountName);
        json.put("accountAuthority", accountAuthority);
        json.put("accountPid", accountPid);
        json.put("accountDepartment", accountDepartment);
        json.put("accountTitle", accountTitle);
        json.put("accountConfirmBit", accountConfirmBit);
        if(accountConfirmBit==-1){
            json.put("accountId",json.getString("accountId")+"(已删除)");
        }
        return json;
    }
    public static JSONArray toJSON(ArrayList<Account> accounts){
        JSONArray json = new JSONArray();
        json.add(Account.translate());
        for(Account account : accounts){json.add(account.toJSON());}
        return json;
    }
}