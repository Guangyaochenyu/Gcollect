package com.edu.hrbu.infoengineering.gcollect.adapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.StuProject;
import com.edu.hrbu.infoengineering.gcollect.dao.StuProjectDao;
import java.util.ArrayList;
public class StuProjectAdapter implements StuProjectDao {
    @Override public ArrayList<StuProject> getList(Account account){return null;}
    @Override public ArrayList<StuProject> queryAll(){return null;}
    @Override public ArrayList<StuProject> queryList(Account account){return null;}
    @Override public ArrayList<StuProject> queryEffective(Account account){return null;}
    @Override public Boolean insert(StuProject stuproject, Account account){return null;}
    @Override public Boolean update(StuProject stuproject, Account account){return null;}
    @Override public Boolean delete(StuProject stuproject, Account account){return null;}
}