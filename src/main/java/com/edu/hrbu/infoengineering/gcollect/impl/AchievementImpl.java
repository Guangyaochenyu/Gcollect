package com.edu.hrbu.infoengineering.gcollect.impl;
import com.edu.hrbu.infoengineering.gcollect.adapter.AchievementAdapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Achievement;
import com.edu.hrbu.infoengineering.gcollect.util.Cache;
import com.edu.hrbu.infoengineering.gcollect.util.DAO;
import com.edu.hrbu.infoengineering.gcollect.util.Gtime;
import com.edu.hrbu.infoengineering.gcollect.util.HashQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class AchievementImpl extends AchievementAdapter {
    @Override
    public ArrayList<Achievement> getList(Account account) {
        if (account.getAccountAuthority() == 0) {
            return Cache.getInstance().getAllAchievement();
        } else {
            return queryEffective(account);
        }
    }
    @Override
    public ArrayList<Achievement> queryAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Achievement> achievements;
        try {
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "select * from Achievement";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            achievements = new ArrayList<>();
            while (rs.next()) {
                Achievement achievement = new Achievement();
                achievement.setAchievementId(rs.getInt(1));
                achievement.setAccountId(rs.getInt(2));
                achievement.setAchievementName(rs.getString(3));
                achievement.setAchievmentLevel(rs.getString(4));
                achievement.setAchievementTime(rs.getString(5));
                achievement.setAchievementRemark(rs.getString(6));
                achievement.setAchievementConfirmBit(rs.getInt(11));
                achievements.add(achievement);
            }
            return achievements;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            DAO.close(conn, ps, rs);
        }
    }
    @Override
    public ArrayList<Achievement> queryList(Account account) {
        ArrayList<Account> accounts = new AccountImpl().getList(account);
        ArrayList<Achievement> achievements = new ArrayList<>();
        HashQuery hq = new HashQuery(accounts);
        for (Achievement achievement : Cache.getInstance().getAllAchievement()) {
            if (hq.check(achievement.getAccountId())) {
                achievements.add(achievement);
            }
        }
        return achievements;
    }
    @Override
    public ArrayList<Achievement> queryEffective(Account account) {
        ArrayList<Achievement> achievements = new ArrayList<>();
        for (Achievement achievement : queryList(account)) {
            if (achievement.getAchievementConfirmBit() != -1) {
                achievements.add(achievement);
            }
        }
        return achievements;
    }
    @Override
    public Boolean insert(Achievement achievement, Account account) {
        Cache.getInstance().update("Achievement");
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "insert into Achievement (AccountId, AchievementName, AchievmentLevel, AchievementTime, AchievementRemark, AchievementCreateUser, AchievementCreateTime, AchievementUpdateUser, AchievementUpdateTime, AchievementConfirmBit) values (?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, achievement.getAccountId());
            ps.setString(2, achievement.getAchievementName());
            ps.setString(3, achievement.getAchievmentLevel());
            ps.setString(4, achievement.getAchievementTime());
            ps.setString(5, achievement.getAchievementRemark());
            ps.setInt(6, account.getAccountId());
            ps.setString(7, Gtime.getInstance().toString());
            ps.setInt(8, account.getAccountId());
            ps.setString(9, Gtime.getInstance().toString());
            ps.setInt(10, 0);
            return ps.executeUpdate() != 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            DAO.close(conn, ps, null);
        }
    }
    @Override
    public Boolean update(Achievement achievement, Account account) {
        Cache.getInstance().update("Achievement");
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update Achievement set AccountId=?,AchievementName=?,AchievmentLevel=?,AchievementTime=?,AchievementRemark=?,AchievementUpdateUser=?,AchievementUpdateTime=?,AchievementConfirmBit=? where AchievementId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, achievement.getAccountId());
            ps.setString(2, achievement.getAchievementName());
            ps.setString(3, achievement.getAchievmentLevel());
            ps.setString(4, achievement.getAchievementTime());
            ps.setString(5, achievement.getAchievementRemark());
            ps.setInt(6, account.getAccountId());
            ps.setString(7, Gtime.getInstance().toString());
            ps.setInt(8, 1);
            ps.setInt(9, achievement.getAchievementId());
            return ps.executeUpdate() != 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            DAO.close(conn, ps, null);
        }
    }
    @Override
    public Boolean delete(Achievement achievement, Account account) {
        Cache.getInstance().update("Achievement");
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update Achievement set AchievementUpdateUser=?,AchievementUpdateTime=?,AchievementConfirmBit=? where AchievementId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAccountId());
            ps.setString(2, Gtime.getInstance().toString());
            ps.setInt(3, -1);
            ps.setInt(4, achievement.getAchievementId());
            return ps.executeUpdate() != 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            DAO.close(conn, ps, null);
        }
    }
}