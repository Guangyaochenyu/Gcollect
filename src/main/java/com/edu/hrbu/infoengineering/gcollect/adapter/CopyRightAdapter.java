package com.edu.hrbu.infoengineering.gcollect.adapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.CopyRight;
import com.edu.hrbu.infoengineering.gcollect.dao.CopyRightDao;
import java.util.ArrayList;
public class CopyRightAdapter implements CopyRightDao {
    @Override public ArrayList<CopyRight> getList(Account account){return null;}
    @Override public ArrayList<CopyRight> queryAll(){return null;}
    @Override public ArrayList<CopyRight> queryList(Account account){return null;}
    @Override public ArrayList<CopyRight> queryEffective(Account account){return null;}
    @Override public Boolean insert(CopyRight copyright, Account account){return null;}
    @Override public Boolean update(CopyRight copyright, Account account){return null;}
    @Override public Boolean delete(CopyRight copyright, Account account){return null;}
}