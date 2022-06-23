package com.edu.hrbu.infoengineering.gcollect.dao;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.CopyRight;
import java.util.ArrayList;
public interface CopyRightDao {
    public abstract ArrayList<CopyRight> getList(Account account);
    public abstract ArrayList<CopyRight> queryAll();
    public abstract ArrayList<CopyRight> queryList(Account account);
    public abstract ArrayList<CopyRight> queryEffective(Account account);
    public abstract Boolean insert(CopyRight copyRight, Account account);
    public abstract Boolean update(CopyRight copyRight, Account account);
    public abstract Boolean delete(CopyRight copyRight, Account account);
}