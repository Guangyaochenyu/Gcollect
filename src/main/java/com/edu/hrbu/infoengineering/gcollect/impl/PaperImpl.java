package com.edu.hrbu.infoengineering.gcollect.impl;
import com.edu.hrbu.infoengineering.gcollect.adapter.PaperAdapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Paper;
import com.edu.hrbu.infoengineering.gcollect.util.Cache;
import com.edu.hrbu.infoengineering.gcollect.util.DAO;
import com.edu.hrbu.infoengineering.gcollect.util.Gtime;
import com.edu.hrbu.infoengineering.gcollect.util.HashQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class PaperImpl extends PaperAdapter {
    @Override
    public ArrayList<Paper> getList(Account account) {
        if (account.getAccountAuthority() == 0) {
            return Cache.getInstance().getAllPaper();
        } else {
            return queryEffective(account);
        }
    }
    @Override
    public ArrayList<Paper> queryAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Paper> papers;
        try {
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "select * from Paper";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            papers = new ArrayList<>();
            while (rs.next()) {
                Paper paper = new Paper();
                paper.setPaperId(rs.getInt(1));
                paper.setAccountId(rs.getInt(2));
                paper.setPaperName(rs.getString(3));
                paper.setPaperSource(rs.getString(4));
                paper.setPaperPublishTime(rs.getString(5));
                paper.setPaperCategory(rs.getString(6));
                paper.setPaperRole(rs.getString(7));
                paper.setPaperAchieveType(rs.getString(8));
                paper.setPaperAchieveLevel(rs.getString(9));
                paper.setPaperAwardName(rs.getString(10));
                paper.setPaperAwardLevel(rs.getString(11));
                paper.setPaperAwardTime(rs.getString(12));
                paper.setPaperAwardUnit(rs.getString(13));
                paper.setPaperRemark(rs.getString(14));
                paper.setPaperConfirmBit(rs.getInt(19));
                papers.add(paper);
            }
            return papers;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            DAO.close(conn, ps, rs);
        }
    }
    @Override
    public ArrayList<Paper> queryList(Account account) {
        ArrayList<Account> accounts = new AccountImpl().getList(account);
        ArrayList<Paper> papers = new ArrayList<>();
        HashQuery hq = new HashQuery(accounts);
        for (Paper paper : Cache.getInstance().getAllPaper()) {
            if (hq.check(paper.getAccountId())) {
                papers.add(paper);
            }
        }
        return papers;
    }
    @Override
    public ArrayList<Paper> queryEffective(Account account) {
        ArrayList<Paper> papers = new ArrayList<>();
        for (Paper paper : queryList(account)) {
            if (paper.getPaperConfirmBit() != -1) {
                papers.add(paper);
            }
        }
        return papers;
    }
    @Override
    public Boolean insert(Paper paper, Account account) {
        Cache.getInstance().update("Paper");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "insert into Paper (AccountId, PaperName, PaperSource, PaperPublishTime, PaperCategory, PaperRole, PaperAchieveType, PaperAchieveLevel, PaperAwardName, PaperAwardLevel, PaperAwardTime, PaperAwardUnit, PaperRemark, PaperCreateUser, PaperCreateTime, PaperUpdateUser, PaperUpdateTime, PaperConfirmBit) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, paper.getAccountId());
            ps.setString(2, paper.getPaperName());
            ps.setString(3, paper.getPaperSource());
            ps.setString(4, paper.getPaperPublishTime());
            ps.setString(5, paper.getPaperCategory());
            ps.setString(6, paper.getPaperRole());
            ps.setString(7, paper.getPaperAchieveType());
            ps.setString(8, paper.getPaperAchieveLevel());
            ps.setString(9, paper.getPaperAwardName());
            ps.setString(10, paper.getPaperAwardLevel());
            ps.setString(11, paper.getPaperAwardTime());
            ps.setString(12, paper.getPaperAwardUnit());
            ps.setString(13, paper.getPaperRemark());
            ps.setInt(14, account.getAccountId());
            ps.setString(15, Gtime.getInstance().toString());
            ps.setInt(16, account.getAccountId());
            ps.setString(17, Gtime.getInstance().toString());
            ps.setInt(18, 0);
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally {
            DAO.close(conn, ps, null);
        }
    }
    @Override
    public Boolean update(Paper paper, Account account) {
        Cache.getInstance().update("Paper");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update Paper set AccountId = ?, PaperName = ?, PaperSource = ?, PaperPublishTime = ?, PaperCategory = ?, PaperRole = ?, PaperAchieveType = ?, PaperAchieveLevel = ?, PaperAwardName = ?, PaperAwardLevel = ?, PaperAwardTime = ?, PaperAwardUnit = ?, PaperRemark = ?, PaperUpdateUser = ?, PaperUpdateTime = ?, PaperConfirmBit = ? where PaperId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, paper.getAccountId());
            ps.setString(2, paper.getPaperName());
            ps.setString(3, paper.getPaperSource());
            ps.setString(4, paper.getPaperPublishTime());
            ps.setString(5, paper.getPaperCategory());
            ps.setString(6, paper.getPaperRole());
            ps.setString(7, paper.getPaperAchieveType());
            ps.setString(8, paper.getPaperAchieveLevel());
            ps.setString(9, paper.getPaperAwardName());
            ps.setString(10, paper.getPaperAwardLevel());
            ps.setString(11, paper.getPaperAwardTime());
            ps.setString(12, paper.getPaperAwardUnit());
            ps.setString(13, paper.getPaperRemark());
            ps.setInt(14, account.getAccountId());
            ps.setString(15, Gtime.getInstance().toString());
            ps.setInt(16, 1);
            ps.setInt(17, paper.getPaperId());
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally {
            DAO.close(conn, ps, null);
        }
    }
    @Override
    public Boolean delete(Paper paper, Account account) {
        Cache.getInstance().update("Paper");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update Paper set PaperUpdateUser = ?, PaperUpdateTime = ?, PaperConfirmBit = ? where PaperId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAccountId());
            ps.setString(2, Gtime.getInstance().toString());
            ps.setInt(3, -1);
            ps.setInt(4, paper.getPaperId());
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn, ps, null);
        }
    }
}