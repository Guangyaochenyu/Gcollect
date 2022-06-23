package com.edu.hrbu.infoengineering.gcollect.dao;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Project;
import java.util.ArrayList;
public interface ProjectDao {
    public abstract ArrayList<Project> getList(Account account);
    public abstract ArrayList<Project> queryAll();
    public abstract ArrayList<Project> queryList(Account account);
    public abstract ArrayList<Project> queryEffective(Account account);
    public abstract Boolean insert(Project project, Account account);
    public abstract Boolean update(Project project, Account account);
    public abstract Boolean delete(Project project, Account account);
}