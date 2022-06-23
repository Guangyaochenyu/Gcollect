package com.edu.hrbu.infoengineering.gcollect.adapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Patent;
import com.edu.hrbu.infoengineering.gcollect.dao.PatentDao;
import java.util.ArrayList;
public class PatentAdapter implements PatentDao {
    @Override public ArrayList<Patent> getList(Account account){return null;}
    @Override public ArrayList<Patent> queryAll(){return null;}
    @Override public ArrayList<Patent> queryList(Account account){return null;}
    @Override public ArrayList<Patent> queryEffective(Account account){return null;}
    @Override public Boolean insert(Patent patent, Account account){return null;}
    @Override public Boolean update(Patent patent, Account account){return null;}
    @Override public Boolean delete(Patent patent, Account account){return null;}
}