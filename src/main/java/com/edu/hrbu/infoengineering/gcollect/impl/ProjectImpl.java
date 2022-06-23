package com.edu.hrbu.infoengineering.gcollect.impl;
import com.edu.hrbu.infoengineering.gcollect.adapter.ProjectAdapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Project;
import com.edu.hrbu.infoengineering.gcollect.util.Cache;
import com.edu.hrbu.infoengineering.gcollect.util.DAO;
import com.edu.hrbu.infoengineering.gcollect.util.Gtime;
import com.edu.hrbu.infoengineering.gcollect.util.HashQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class ProjectImpl extends ProjectAdapter {
    @Override
    public ArrayList<Project> getList(Account account) {
        if(account.getAccountAuthority() == 0){
            return Cache.getInstance().getAllProject();
        }else{
            return queryEffective(account);
        }
    }
    @Override
    public ArrayList<Project> queryAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Project> projects;
        try {
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "select * from Project";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            projects = new ArrayList<>();
            while (rs.next()) {
                Project project = new Project();
                project.setProjectId(rs.getInt(1));
                project.setAccountId(rs.getInt(2));
                project.setProjectName(rs.getString(3));
                project.setProjectSource(rs.getString(4));
                project.setProjectNumber(rs.getString(5));
                project.setProjectStartTime(rs.getString(6));
                project.setProjectEndTime(rs.getString(7));
                project.setProjectFund(rs.getInt(8));
                project.setProjectAwardName(rs.getString(9));
                project.setProjectAwardLevel(rs.getString(10));
                project.setProjectAwardTime(rs.getString(11));
                project.setProjectAwardUnit(rs.getString(12));
                project.setProjectRemark(rs.getString(13));
                project.setProjectConfirmBit(rs.getInt(18));
                projects.add(project);
            }
            return projects;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            DAO.close(conn, ps, rs);
        }
    }
    @Override
    public ArrayList<Project> queryList(Account account){
        ArrayList<Account> accounts = new AccountImpl().getList(account);
        ArrayList<Project> projects = new ArrayList<>();
        HashQuery h1 = new HashQuery(accounts);
        for(Project project : Cache.getInstance().getAllProject()){
            if(h1.check(project.getAccountId())){
                projects.add(project);
            }
        }
        return projects;
    }
    @Override
    public ArrayList<Project> queryEffective(Account account) {
        ArrayList<Project> projects = new ArrayList<>();
        for(Project project : queryList(account)){
            if(project.getProjectConfirmBit() != -1){
                projects.add(project);
            }
        }
        return projects;
    }
    @Override
    public Boolean insert(Project project, Account account) {
        Cache.getInstance().update("Project");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "insert into Project (AccountId, ProjectName, ProjectSource, ProjectNumber, ProjectStartTime, ProjectEndTime, ProjectFund, ProjectAwardName, ProjectAwardLevel, ProjectAwardTime, ProjectAwardUnit, ProjectRemark, ProjectCreateUser, ProjectCreateTime, ProjectUpdateUser, ProjectUpdateTime, ProjectConfirmBit) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, project.getAccountId());
            ps.setString(2, project.getProjectName());
            ps.setString(3, project.getProjectSource());
            ps.setString(4, project.getProjectNumber());
            ps.setString(5, project.getProjectStartTime());
            ps.setString(6, project.getProjectEndTime());
            ps.setInt(7, project.getProjectFund());
            ps.setString(8, project.getProjectAwardName());
            ps.setString(9, project.getProjectAwardLevel());
            ps.setString(10, project.getProjectAwardTime());
            ps.setString(11, project.getProjectAwardUnit());
            ps.setString(12, project.getProjectRemark());
            ps.setInt(13, account.getAccountId());
            ps.setString(14, Gtime.getInstance().toString());
            ps.setInt(15, account.getAccountId());
            ps.setString(16, Gtime.getInstance().toString());
            ps.setInt(17,0);
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn, ps, null);
        }
    }
    @Override
    public Boolean update(Project project, Account account) {
        Cache.getInstance().update("Project");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update Project set AccountId = ?, ProjectName = ?, ProjectSource = ?, ProjectNumber = ?, ProjectStartTime = ?, ProjectEndTime = ?, ProjectFund = ?, ProjectAwardName = ?, ProjectAwardLevel = ?, ProjectAwardTime = ?, ProjectAwardUnit = ?, ProjectRemark = ?, ProjectUpdateUser = ?, ProjectUpdateTime = ?, ProjectConfirmBit = ? where ProjectId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, project.getAccountId());
            ps.setString(2, project.getProjectName());
            ps.setString(3, project.getProjectSource());
            ps.setString(4, project.getProjectNumber());
            ps.setString(5, project.getProjectStartTime());
            ps.setString(6, project.getProjectEndTime());
            ps.setInt(7, project.getProjectFund());
            ps.setString(8, project.getProjectAwardName());
            ps.setString(9, project.getProjectAwardLevel());
            ps.setString(10, project.getProjectAwardTime());
            ps.setString(11, project.getProjectAwardUnit());
            ps.setString(12, project.getProjectRemark());
            ps.setInt(13, account.getAccountId());
            ps.setString(14, Gtime.getInstance().toString());
            ps.setInt(15, 1);
            ps.setInt(16, project.getProjectId());
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally {
            DAO.close(conn, ps, null);
        }
    }
    @Override
    public Boolean delete(Project project, Account account) {
        Cache.getInstance().update("Project");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update Project set ProjectUpdateUser = ?, ProjectUpdateTime = ?, ProjectConfirmBit = ? where ProjectId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAccountId());
            ps.setString(2, Gtime.getInstance().toString());
            ps.setInt(3, -1);
            ps.setInt(4, project.getProjectId());
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn, ps, null);
        }
    }
}