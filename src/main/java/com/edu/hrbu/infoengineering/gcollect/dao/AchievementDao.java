package com.edu.hrbu.infoengineering.gcollect.dao;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Achievement;
import java.util.ArrayList;
public interface AchievementDao {
    public abstract ArrayList<Achievement> getList(Account account);
    public abstract ArrayList<Achievement> queryAll();
    public abstract ArrayList<Achievement> queryList(Account account);
    public abstract ArrayList<Achievement> queryEffective(Account account);
    public abstract Boolean insert(Achievement achievement, Account account);
    public abstract Boolean update(Achievement achievement, Account account);
    public abstract Boolean delete(Achievement achievement, Account account);
}