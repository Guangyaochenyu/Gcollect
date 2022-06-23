package com.edu.hrbu.infoengineering.gcollect.adapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Paper;
import com.edu.hrbu.infoengineering.gcollect.dao.PaperDao;
import java.util.ArrayList;
public class PaperAdapter implements PaperDao {
    @Override public ArrayList<Paper> getList(Account account){return null;}
    @Override public ArrayList<Paper> queryAll(){return null;}
    @Override public ArrayList<Paper> queryList(Account account){return null;}
    @Override public ArrayList<Paper> queryEffective(Account account){return null;}
    @Override public Boolean insert(Paper paper, Account account){return null;}
    @Override public Boolean update(Paper paper, Account account){return null;}
    @Override public Boolean delete(Paper paper, Account account){return null;}
}