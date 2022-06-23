package com.edu.hrbu.infoengineering.gcollect.dao;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import java.util.ArrayList;
import java.util.HashMap;
public interface AccountDao {
    public abstract ArrayList<Account> getList(Account account);
    public abstract ArrayList<Account> queryAll();
    public abstract ArrayList<Account> queryEffective();
    public abstract ArrayList<Account> queryDepartment(String department);
    public abstract ArrayList<Account> querySelf(int accountId);
    public abstract Account query(int accountId);
    public abstract Account query(String accountNumber);
    public abstract Boolean insert(Account account);
    public abstract Boolean update(Account account);
    public abstract Boolean delete(Account account);
    public abstract HashMap<Integer,String> map();
}
