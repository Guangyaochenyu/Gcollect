package com.edu.hrbu.infoengineering.gcollect.impl;
import com.edu.hrbu.infoengineering.gcollect.adapter.PatentAdapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Patent;
import com.edu.hrbu.infoengineering.gcollect.util.Cache;
import com.edu.hrbu.infoengineering.gcollect.util.DAO;
import com.edu.hrbu.infoengineering.gcollect.util.Gtime;
import com.edu.hrbu.infoengineering.gcollect.util.HashQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class PatentImpl extends PatentAdapter {
    @Override
    public ArrayList<Patent> getList(Account account) {
        if(account.getAccountAuthority() == 0){
            return Cache.getInstance().getAllPatent();
        }else{
            return queryEffective(account);
        }
    }
    @Override
    public ArrayList<Patent> queryAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Patent> patents;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "select * from Patent";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            patents = new ArrayList<>();
            while(rs.next()){
                Patent patent = new Patent();
                patent.setPatentId(rs.getInt(1));
                patent.setAccountId(rs.getInt(2));
                patent.setPatentName(rs.getString(3));
                patent.setPatentNumber(rs.getString(4));
                patent.setPatentType(rs.getString(5));
                patent.setPatentFilingTime(rs.getString(6));
                patent.setPatentAcquisitionTime(rs.getString(7));
                patent.setPatentRole(rs.getString(8));
                patent.setPatentAwardName(rs.getString(9));
                patent.setPatentAwardLevel(rs.getString(10));
                patent.setPatentAwardTime(rs.getString(11));
                patent.setPatentAwardUnit(rs.getString(12));
                patent.setPatentRemark(rs.getString(13));
                patent.setPatentConfirmBit(rs.getInt(18));
                patents.add(patent);
            }
            return patents;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            DAO.close(conn, ps, rs);
        }
    }
    @Override
    public ArrayList<Patent> queryList(Account account) {
        ArrayList<Account> accounts = new AccountImpl().getList(account);
        ArrayList<Patent> patents = new ArrayList<>();
        HashQuery hq = new HashQuery(accounts);
        for(Patent patent : Cache.getInstance().getAllPatent()){
            if(hq.check(patent.getAccountId())){
                patents.add(patent);
            }
        }
        return patents;
    }
    @Override
    public ArrayList<Patent> queryEffective(Account account) {
        ArrayList<Patent> patents = new ArrayList<>();
        for(Patent patent : queryList(account)){
            if(patent.getPatentConfirmBit() != -1){
                patents.add(patent);
            }
        }
        return patents;
    }
    @Override
    public Boolean insert(Patent patent, Account account) {
        Cache.getInstance().update("Patent");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "insert into Patent (AccountId, PatentName, PatentNumber, PatentType, PatentFilingTime, PatentAcquisitionTime, PatentRole, PatentAwardName, PatentAwardLevel, PatentAwardTime, PatentAwardUnit, PatentRemark, PatentCreateUser, PatentCreateTime, PatentUpdateUser, PatentUpdateTime, PatentConfirmBit) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, patent.getAccountId());
            ps.setString(2, patent.getPatentName());
            ps.setString(3, patent.getPatentNumber());
            ps.setString(4, patent.getPatentType());
            ps.setString(5, patent.getPatentFilingTime());
            ps.setString(6, patent.getPatentAcquisitionTime());
            ps.setString(7, patent.getPatentRole());
            ps.setString(8, patent.getPatentAwardName());
            ps.setString(9, patent.getPatentAwardLevel());
            ps.setString(10, patent.getPatentAwardTime());
            ps.setString(11, patent.getPatentAwardUnit());
            ps.setString(12, patent.getPatentRemark());
            ps.setInt(13, account.getAccountId());
            ps.setString(14, Gtime.getInstance().toString());
            ps.setInt(15, account.getAccountId());
            ps.setString(16, Gtime.getInstance().toString());
            ps.setInt(17, 0);
            return ps.executeUpdate() != 0;
        }catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally {
            DAO.close(conn, ps, null);
        }
    }
    @Override
    public Boolean update(Patent patent, Account account) {
        Cache.getInstance().update("Patent");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update Patent set AccountId = ?, PatentName = ?, PatentNumber = ?, PatentType = ?, PatentFilingTime = ?, PatentAcquisitionTime = ?, PatentRole = ?, PatentAwardName = ?, PatentAwardLevel = ?, PatentAwardTime = ?, PatentAwardUnit = ?, PatentRemark = ?, PatentUpdateUser = ?, PatentUpdateTime = ?, PatentConfirmBit = ? where PatentId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, patent.getAccountId());
            ps.setString(2, patent.getPatentName());
            ps.setString(3, patent.getPatentNumber());
            ps.setString(4, patent.getPatentType());
            ps.setString(5, patent.getPatentFilingTime());
            ps.setString(6, patent.getPatentAcquisitionTime());
            ps.setString(7, patent.getPatentRole());
            ps.setString(8, patent.getPatentAwardName());
            ps.setString(9, patent.getPatentAwardLevel());
            ps.setString(10, patent.getPatentAwardTime());
            ps.setString(11, patent.getPatentAwardUnit());
            ps.setString(12, patent.getPatentRemark());
            ps.setInt(13, account.getAccountId());
            ps.setString(14, Gtime.getInstance().toString());
            ps.setInt(15,1);
            ps.setInt(16, patent.getPatentId());
            return ps.executeUpdate() != 0;
        }catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally {
            DAO.close(conn, ps, null);
        }
    }
    @Override
    public Boolean delete(Patent patent, Account account) {
        Cache.getInstance().update("Patent");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update Patent set PatentUpdateUser = ?, PatentUpdateTime = ?, PatentConfirmBit = ? where PatentId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAccountId());
            ps.setString(2, Gtime.getInstance().toString());
            ps.setInt(3, -1);
            ps.setInt(4, patent.getPatentId());
            return ps.executeUpdate() != 0;
        }catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally {
            DAO.close(conn, ps, null);
        }
    }
}