package com.edu.hrbu.infoengineering.gcollect.impl;
import com.edu.hrbu.infoengineering.gcollect.adapter.AccountAdapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.util.Cache;
import com.edu.hrbu.infoengineering.gcollect.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
public class AccountImpl extends AccountAdapter {
    @Override
    public ArrayList<Account> getList(Account account) {
        switch (account.getAccountAuthority()){
            case 0:
                return Cache.getInstance().getAllAccount();
            case 1:
                return queryEffective();
            case 2:
                return queryDepartment(account.getAccountDepartment());
            case 3:
                return querySelf(account.getAccountId());
            default:
                return  new ArrayList<>();
        }
    }
    @Override
    public ArrayList<Account> queryAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Account> accounts;
        try {
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "select * from Account";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            accounts = new ArrayList<>();
            while(rs.next()){
                Account account = new Account();
                account.setAccountId(rs.getInt(1));
                account.setAccountNumber(rs.getString(2));
                account.setAccountPassword(rs.getString(3));
                account.setAccountName(rs.getString(4));
                account.setAccountAuthority(rs.getInt(5));
                account.setAccountPid(rs.getString(6));
                account.setAccountDepartment(rs.getString(7));
                account.setAccountTitle(rs.getString(8));
                account.setAccountConfirmBit(rs.getInt(9));
                accounts.add(account);
            }
            return accounts;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }finally{
            DAO.close(conn,ps,rs);
        }
    }
    @Override
    public ArrayList<Account> queryEffective() {
        ArrayList<Account> accounts = new ArrayList<>();
        for(Account account : Cache.getInstance().getAllAccount()){
            if(account.getAccountConfirmBit() != -1){
                accounts.add(account);
            }
        }
        return accounts;
    }
    @Override
    public ArrayList<Account> queryDepartment(String department) {
        ArrayList<Account> accounts = new ArrayList<>();
        for(Account account : queryEffective()){
            if(department.equals(account.getAccountDepartment())){
                accounts.add(account);
            }
        }
        return accounts;
    }
    @Override
    public ArrayList<Account> querySelf(int accountId) {
        ArrayList<Account> accounts = new ArrayList<>();
        for(Account account : queryEffective()){
            if(account.getAccountId() == accountId){
                accounts.add(account);
            }
        }
        return accounts;
    }
    @Override
    public Account query(int accountId) {
        for(Account account : queryEffective()){
            if(account.getAccountId() == accountId){
                return account;
            }
        }
        return null;
    }
    @Override
    public Account query(String accountNumber) {
        for(Account account : queryEffective()){
            if(accountNumber.equals(account.getAccountNumber())){
                return account;
            }
        }
        return null;
    }
    @Override
    public Boolean insert(Account account) {
        Cache.getInstance().update("Account");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "insert into Account (AccountNumber, AccountPassword, AccountName, AccountAuthority, AccountPid, AccountDepartment, AccountTitle, AccountConfirmBit) values(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,account.getAccountNumber());
            ps.setString(2,account.getAccountPassword());
            ps.setString(3,account.getAccountName());
            ps.setInt(4,account.getAccountAuthority());
            ps.setString(5,account.getAccountPid());
            ps.setString(6,account.getAccountDepartment());
            ps.setString(7,account.getAccountTitle());
            ps.setInt(8,0);
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn,ps,null);
        }
    }
    @Override
    public Boolean update(Account account) {
        Cache.getInstance().update("Account");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update Account set AccountNumber = ?, AccountPassword = ?, AccountName = ?, AccountAuthority = ?, AccountPid = ?, AccountDepartment = ?, AccountTitle = ?, AccountConfirmBit = ? where AccountId = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,account.getAccountNumber());
            ps.setString(2,account.getAccountPassword());
            ps.setString(3,account.getAccountName());
            ps.setInt(4,account.getAccountAuthority());
            ps.setString(5,account.getAccountPid());
            ps.setString(6,account.getAccountDepartment());
            ps.setString(7,account.getAccountTitle());
            ps.setInt(8,1);
            ps.setInt(9,account.getAccountId());
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn,ps,null);
        }
    }
    @Override
    public Boolean delete(Account account) {
        Cache.getInstance().update("Account");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update Account set AccountConfirmBit = ? where AccountId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,-1);
            ps.setInt(2,account.getAccountId());
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn,ps,null);
        }
    }
    @Override
    public HashMap<Integer,String>map(){
        HashMap<Integer,String> map = new HashMap<>();
        for(Account account : Cache.getInstance().getAllAccount()){
            map.put(account.getAccountId(),account.getAccountName());
        }
        return map;
    }
}