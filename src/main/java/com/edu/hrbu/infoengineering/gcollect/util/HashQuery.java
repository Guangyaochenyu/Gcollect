package com.edu.hrbu.infoengineering.gcollect.util;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import java.util.ArrayList;
import java.util.HashMap;
public class HashQuery {
    private HashMap<Integer,String> map;
    public HashQuery(ArrayList<Account> accounts){
        map = new HashMap<>();
        for(Account account : accounts){
            map.put(account.getAccountId(),account.getAccountNumber());
        }
    }
    public Boolean check(int accountId){
        return map.containsKey(accountId);
    }
}
