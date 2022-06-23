package com.edu.hrbu.infoengineering.gcollect.dao;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Patent;
import java.util.ArrayList;
public interface PatentDao {
    public abstract ArrayList<Patent> getList(Account account);
    public abstract ArrayList<Patent> queryAll();
    public abstract ArrayList<Patent> queryList(Account account);
    public abstract ArrayList<Patent> queryEffective(Account account);
    public abstract Boolean insert(Patent patent, Account account);
    public abstract Boolean update(Patent patent, Account account);
    public abstract Boolean delete(Patent patent, Account account);
}