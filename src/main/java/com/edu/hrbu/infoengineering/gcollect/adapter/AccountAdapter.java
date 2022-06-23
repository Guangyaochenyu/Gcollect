package com.edu.hrbu.infoengineering.gcollect.adapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.dao.AccountDao;
import java.util.ArrayList;
import java.util.HashMap;
public class AccountAdapter implements AccountDao {
    @Override public ArrayList<Account> getList(Account account) {return null;}
    @Override public ArrayList<Account> queryAll() {return null;}
    @Override public ArrayList<Account> queryEffective() {return null;}
    @Override public ArrayList<Account> queryDepartment(String department) {return null;}
    @Override public ArrayList<Account> querySelf(int accountId) {return null;}
    @Override public Account query(int accountId) {return null;}
    @Override public Account query(String accountNumber) {return null;}
    @Override public Boolean insert(Account account) {return null;}
    @Override public Boolean update(Account account) {return null;}
    @Override public Boolean delete(Account account) {return null;}
    @Override public HashMap<Integer,String> map() {return null;}
}
