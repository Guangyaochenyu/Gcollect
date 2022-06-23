package com.edu.hrbu.infoengineering.gcollect.impl;
import com.edu.hrbu.infoengineering.gcollect.adapter.CopyRightAdapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.CopyRight;
import com.edu.hrbu.infoengineering.gcollect.util.Cache;
import com.edu.hrbu.infoengineering.gcollect.util.DAO;
import com.edu.hrbu.infoengineering.gcollect.util.Gtime;
import com.edu.hrbu.infoengineering.gcollect.util.HashQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class CopyRightImpl extends CopyRightAdapter {
    @Override
    public ArrayList<CopyRight> getList(Account account) {
        if (account.getAccountAuthority() == 0) {
            return Cache.getInstance().getAllCopyRight();
        } else {
            return queryEffective(account);
        }
    }
    @Override
    public ArrayList<CopyRight> queryAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CopyRight> copyRights;
        try {
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "select * from CopyRight";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            copyRights = new ArrayList<>();
            while (rs.next()) {
                CopyRight copyRight = new CopyRight();
                copyRight.setCopyRightId(rs.getInt(1));
                copyRight.setAccountId(rs.getInt(2));
                copyRight.setCopyRightName(rs.getString(3));
                copyRight.setCopyRightNumber(rs.getString(4));
                copyRight.setCopyRightObtainTime(rs.getString(5));
                copyRight.setCopyRightRemark(rs.getString(6));
                copyRight.setCopyRightConfirmBit(rs.getInt(11));
                copyRights.add(copyRight);
            }
            return copyRights;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            DAO.close(conn, ps, rs);
        }
    }
    @Override
    public ArrayList<CopyRight> queryList(Account account) {
        ArrayList<Account> accounts = new AccountImpl().getList(account);
        ArrayList<CopyRight> copyRights = new ArrayList<>();
        HashQuery hq = new HashQuery(accounts);
        for(CopyRight copyRight : Cache.getInstance().getAllCopyRight()) {
            if(hq.check(copyRight.getAccountId())) {
                copyRights.add(copyRight);
            }
        }
        return copyRights;
    }
    @Override
    public ArrayList<CopyRight> queryEffective(Account account) {
        ArrayList<CopyRight> copyRights = new ArrayList<>();
        for(CopyRight copyRight : queryList(account)) {
            if(copyRight.getCopyRightConfirmBit() != -1) {
                copyRights.add(copyRight);
            }
        }
        return copyRights;
    }
    @Override
    public Boolean insert(CopyRight copyright, Account account) {
        Cache.getInstance().update("CopyRight");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "insert into CopyRight (AccountId, CopyRightName, CopyRightNumber, CopyRightObtainTime, CopyRightRemark, CopyRightCreateUser, CopyRightCreateTime, CopyRightUpdateUser, CopyRightUpdateTime, CopyRightConfirmBit) values (?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAccountId());
            ps.setString(2, copyright.getCopyRightName());
            ps.setString(3, copyright.getCopyRightNumber());
            ps.setString(4, copyright.getCopyRightObtainTime());
            ps.setString(5, copyright.getCopyRightRemark());
            ps.setInt(6, account.getAccountId());
            ps.setString(7, Gtime.getInstance().toString());
            ps.setInt(8, account.getAccountId());
            ps.setString(9, Gtime.getInstance().toString());
            ps.setInt(10, 0);
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn, ps, null);
        }
    }
    @Override
    public Boolean update(CopyRight copyright, Account account) {
        Cache.getInstance().update("CopyRight");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update CopyRight set CopyRightName = ?, CopyRightNumber = ?, CopyRightObtainTime = ?, CopyRightRemark = ?, CopyRightUpdateUser = ?, CopyRightUpdateTime = ?, CopyRightConfirmBit = ? where CopyRightId = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, copyright.getCopyRightName());
            ps.setString(2, copyright.getCopyRightNumber());
            ps.setString(3, copyright.getCopyRightObtainTime());
            ps.setString(4, copyright.getCopyRightRemark());
            ps.setInt(5, account.getAccountId());
            ps.setString(6, Gtime.getInstance().toString());
            ps.setInt(7, 1);
            ps.setInt(8, copyright.getCopyRightId());
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn, ps, null);
        }
    }
    @Override
    public Boolean delete(CopyRight copyright, Account account) {
        Cache.getInstance().update("CopyRight");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update CopyRight set CopyRightUpdateUser = ?, CopyRightUpdateTime = ?, CopyRightConfirmBit = ? where CopyRightId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAccountId());
            ps.setString(2, Gtime.getInstance().toString());
            ps.setInt(3, -1);
            ps.setInt(4, copyright.getCopyRightId());
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn, ps, null);
        }
    }
}