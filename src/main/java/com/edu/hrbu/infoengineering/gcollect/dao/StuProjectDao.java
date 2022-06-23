package com.edu.hrbu.infoengineering.gcollect.dao;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.StuProject;
import java.util.ArrayList;
public interface StuProjectDao {
    public abstract ArrayList<StuProject> getList(Account account);
    public abstract ArrayList<StuProject> queryAll();
    public abstract ArrayList<StuProject> queryList(Account account);
    public abstract ArrayList<StuProject> queryEffective(Account account);
    public abstract Boolean insert(StuProject stuProject, Account account);
    public abstract Boolean update(StuProject stuProject, Account account);
    public abstract Boolean delete(StuProject stuProject, Account account);
}