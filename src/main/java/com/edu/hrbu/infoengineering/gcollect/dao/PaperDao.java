package com.edu.hrbu.infoengineering.gcollect.dao;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Paper;
import java.util.ArrayList;
public interface PaperDao {
    public abstract ArrayList<Paper> getList(Account account);
    public abstract ArrayList<Paper> queryAll();
    public abstract ArrayList<Paper> queryList(Account account);
    public abstract ArrayList<Paper> queryEffective(Account account);
    public abstract Boolean insert(Paper paper, Account account);
    public abstract Boolean update(Paper paper, Account account);
    public abstract Boolean delete(Paper paper, Account account);
}