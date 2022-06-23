package com.edu.hrbu.infoengineering.gcollect.adapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Project;
import com.edu.hrbu.infoengineering.gcollect.dao.ProjectDao;
import java.util.ArrayList;
public class ProjectAdapter implements ProjectDao {
    @Override public ArrayList<Project> getList(Account account){return null;}
    @Override public ArrayList<Project> queryAll(){return null;}
    @Override public ArrayList<Project> queryList(Account account){return null;}
    @Override public ArrayList<Project> queryEffective(Account account){return null;}
    @Override public Boolean insert(Project project, Account account){return null;}
    @Override public Boolean update(Project project, Account account){return null;}
    @Override public Boolean delete(Project project, Account account){return null;}
}