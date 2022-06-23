package com.edu.hrbu.infoengineering.gcollect.impl;
import com.edu.hrbu.infoengineering.gcollect.adapter.StuProjectAdapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.StuProject;
import com.edu.hrbu.infoengineering.gcollect.util.Cache;
import com.edu.hrbu.infoengineering.gcollect.util.DAO;
import com.edu.hrbu.infoengineering.gcollect.util.Gtime;
import com.edu.hrbu.infoengineering.gcollect.util.HashQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class StuProjectImpl extends StuProjectAdapter {
    @Override
    public ArrayList<StuProject> getList(Account account) {
        if(account.getAccountAuthority()==0){
            return Cache.getInstance().getAllStuProject();
        }else{
            return queryEffective(account);
        }
    }
    @Override
    public ArrayList<StuProject> queryAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<StuProject> stuProjects;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "select * from StuProject";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            stuProjects = new ArrayList<>();
            while(rs.next()){
                StuProject stuProject = new StuProject();
                stuProject.setStuProjectId(rs.getInt(1));
                stuProject.setAccountId(rs.getInt(2));
                stuProject.setStuProjectNumber(rs.getString(3));
                stuProject.setStuProjectName(rs.getString(4));
                stuProject.setStuProjectLeader(rs.getString(5));
                stuProject.setStuProjectCategory(rs.getString(6));
                stuProject.setStuProjectType(rs.getString(7));
                stuProject.setStuProjectRemark(rs.getString(8));
                stuProject.setStuProjectConfirmBit(rs.getInt(13));
                stuProjects.add(stuProject);
            }
            return stuProjects;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }finally{
            DAO.close(conn,ps,rs);
        }
    }
    @Override
    public ArrayList<StuProject> queryList(Account account) {
        ArrayList<Account> accounts = new AccountImpl().getList(account);
        ArrayList<StuProject> stuProjects = new ArrayList<>();
        HashQuery h1 = new HashQuery(accounts);
        for(StuProject stuProject:Cache.getInstance().getAllStuProject()) {
            if (h1.check(stuProject.getAccountId())) {
                stuProjects.add(stuProject);
            }
        }
        return stuProjects;
    }
    @Override
    public ArrayList<StuProject> queryEffective(Account account) {
        ArrayList<StuProject> stuProjects = new ArrayList<>();
        for(StuProject stuProject : queryList(account)){
            if(stuProject.getStuProjectConfirmBit() != -1){
                stuProjects.add(stuProject);
            }
        }
        return stuProjects;
    }
    @Override
    public Boolean insert(StuProject stuproject, Account account) {
        Cache.getInstance().update("StuProject");
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "insert into StuProject(AccountId,StuProjectNumber,StuProjectName,StuProjectLeader,StuProjectCategory,StuProjectType, StuProjectRemark,StuProjectCreateUser,StuProjectCreateTime,StuProjectUpdateUser,StuProjectUpdateTime,StuProjectConfirmBit) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, stuproject.getAccountId());
            ps.setString(2, stuproject.getStuProjectNumber());
            ps.setString(3, stuproject.getStuProjectName());
            ps.setString(4, stuproject.getStuProjectLeader());
            ps.setString(5, stuproject.getStuProjectCategory());
            ps.setString(6, stuproject.getStuProjectType());
            ps.setString(7, stuproject.getStuProjectRemark());
            ps.setInt(8, account.getAccountId());
            ps.setString(9, Gtime.getInstance().toString());
            ps.setInt(10, account.getAccountId());
            ps.setString(11, Gtime.getInstance().toString());
            ps.setInt(12, 0);
            return ps.executeUpdate() != 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }finally {
            DAO.close(conn,ps,null);
        }
    }
    @Override
    public Boolean update(StuProject stuproject, Account account) {
        Cache.getInstance().update("StuProject");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update StuProject set StuProjectNumber=?,StuProjectName=?,StuProjectLeader=?,StuProjectCategory=?,StuProjectType=?,StuProjectRemark=?,StuProjectUpdateUser=?,StuProjectUpdateTime=?,StuProjectConfirmBit=? where StuProjectId=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, stuproject.getStuProjectNumber());
            ps.setString(2, stuproject.getStuProjectName());
            ps.setString(3, stuproject.getStuProjectLeader());
            ps.setString(4, stuproject.getStuProjectCategory());
            ps.setString(5, stuproject.getStuProjectType());
            ps.setString(6, stuproject.getStuProjectRemark());
            ps.setInt(7, account.getAccountId());
            ps.setString(8, Gtime.getInstance().toString());
            ps.setInt(9, 1);
            ps.setInt(10, stuproject.getStuProjectId());
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally {
            DAO.close(conn,ps,null);
        }
    }
    @Override
    public Boolean delete(StuProject stuproject, Account account) {
        Cache.getInstance().update("StuProject");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update StuProject set StuProjectUpdateUser=?,StuProjectUpdateTime=?,StuProjectConfirmBit=? where StuProjectId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAccountId());
            ps.setString(2, Gtime.getInstance().toString());
            ps.setInt(3, -1);
            ps.setInt(4, stuproject.getStuProjectId());
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn,ps,null);
        }
    }
}