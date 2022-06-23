package com.edu.hrbu.infoengineering.gcollect.adapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Achievement;
import com.edu.hrbu.infoengineering.gcollect.dao.AchievementDao;
import java.util.ArrayList;
public class AchievementAdapter implements AchievementDao {
    @Override public ArrayList<Achievement> getList(Account account){return null;}
    @Override public ArrayList<Achievement> queryAll(){return null;}
    @Override public ArrayList<Achievement> queryList(Account account){return null;}
    @Override public ArrayList<Achievement> queryEffective(Account account){return null;}
    @Override public Boolean insert(Achievement achievement, Account account){return null;}
    @Override public Boolean update(Achievement achievement, Account account){return null;}
    @Override public Boolean delete(Achievement achievement, Account account){return null;}
}