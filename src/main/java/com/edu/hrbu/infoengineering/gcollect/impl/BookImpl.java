package com.edu.hrbu.infoengineering.gcollect.impl;
import com.edu.hrbu.infoengineering.gcollect.adapter.BookAdapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Book;
import com.edu.hrbu.infoengineering.gcollect.util.Cache;
import com.edu.hrbu.infoengineering.gcollect.util.DAO;
import com.edu.hrbu.infoengineering.gcollect.util.Gtime;
import com.edu.hrbu.infoengineering.gcollect.util.HashQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class BookImpl extends BookAdapter {
    @Override
    public ArrayList<Book> getList(Account account) {
        if(account.getAccountAuthority() == 0){
            return Cache.getInstance().getAllBook();
        }else{
            return queryEffective(account);
        }
    }
    @Override
    public ArrayList<Book> queryAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Book> books;
        try {
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "select * from Book";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            books = new ArrayList<>();
            while(rs.next()){
                Book book = new Book();
                book.setBookId(rs.getInt(1));
                book.setAccountId(rs.getInt(2));
                book.setBookName(rs.getString(3));
                book.setBookPublisher(rs.getString(4));
                book.setBookPublishTime(rs.getString(5));
                book.setBookIsbn(rs.getString(6));
                book.setBookCategory(rs.getString(7));
                book.setBookRole(rs.getString(8));
                book.setBookAwardName(rs.getString(9));
                book.setBookAwardLevel(rs.getString(10));
                book.setBookAwardTime(rs.getString(11));
                book.setBookAwardUnit(rs.getString(12));
                book.setBookRemark(rs.getString(13));
                book.setBookConfirmBit(rs.getInt(18));
                books.add(book);
            }
            return books;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            DAO.close(conn, ps, rs);
        }
    }
    @Override
    public ArrayList<Book> queryList(Account account) {
        ArrayList<Account> accounts = new AccountImpl().getList(account);
        ArrayList<Book> books = new ArrayList<>();
        HashQuery hq = new HashQuery(accounts);
        for(Book book : Cache.getInstance().getAllBook()){
            if(hq.check(book.getAccountId())){
                books.add(book);
            }
        }
        return books;
    }
    @Override
    public ArrayList<Book> queryEffective(Account account) {
        ArrayList<Book> books = new ArrayList<>();
        for(Book book : queryList(account)){
            if(book.getBookConfirmBit() != -1){
                books.add(book);
            }
        }
        return books;
    }
    @Override
    public Boolean insert(Book book, Account account) {
        Cache.getInstance().update("Book");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "insert into Book (AccountId,BookName,BookPublisher,BookPublishTime,BookIsbn,BookCategory,BookRole,BookAwardName,BookAwardLevel,BookAwardTime,BookAwardUnit,BookRemark,BookCreateUser,BookCreateTime,BookUpdateUser,BookUpdateTime,BookConfirmBit) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAccountId());
            ps.setString(2, book.getBookName());
            ps.setString(3, book.getBookPublisher());
            ps.setString(4, book.getBookPublishTime());
            ps.setString(5, book.getBookIsbn());
            ps.setString(6, book.getBookCategory());
            ps.setString(7, book.getBookRole());
            ps.setString(8, book.getBookAwardName());
            ps.setString(9, book.getBookAwardLevel());
            ps.setString(10, book.getBookAwardTime());
            ps.setString(11, book.getBookAwardUnit());
            ps.setString(12, book.getBookRemark());
            ps.setInt(13, account.getAccountId());
            ps.setString(14, Gtime.getInstance().toString());
            ps.setInt(15, account.getAccountId());
            ps.setString(16, Gtime.getInstance().toString());
            ps.setInt(17, 0);
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn, ps, null);
        }
    }
    @Override
    public Boolean update(Book book, Account account) {
        Cache.getInstance().update("Book");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update Book set AccountId=?,BookName=?,BookPublisher=?,BookPublishTime=?,BookIsbn=?,BookCategory=?,BookRole=?,BookAwardName=?,BookAwardLevel=?,BookAwardTime=?,BookAwardUnit=?,BookRemark=?,BookUpdateUser=?,BookUpdateTime=?,BookConfirmBit=? where BookId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAccountId());
            ps.setString(2, book.getBookName());
            ps.setString(3, book.getBookPublisher());
            ps.setString(4, book.getBookPublishTime());
            ps.setString(5, book.getBookIsbn());
            ps.setString(6, book.getBookCategory());
            ps.setString(7, book.getBookRole());
            ps.setString(8, book.getBookAwardName());
            ps.setString(9, book.getBookAwardLevel());
            ps.setString(10, book.getBookAwardTime());
            ps.setString(11, book.getBookAwardUnit());
            ps.setString(12, book.getBookRemark());
            ps.setInt(13, account.getAccountId());
            ps.setString(14, Gtime.getInstance().toString());
            ps.setInt(15, 1);
            ps.setInt(16, book.getBookId());
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn, ps, null);
        }
    }
    @Override
    public Boolean delete(Book book, Account account) {
        Cache.getInstance().update("Book");
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DAO.getConnection();
            assert conn != null;
            String sql = "update Book set BookUpdateUser=?,BookUpdateTime=?,BookConfirmBit=? where BookId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getAccountId());
            ps.setString(2, Gtime.getInstance().toString());
            ps.setInt(3, -1);
            ps.setInt(4, book.getBookId());
            return ps.executeUpdate() != 0;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }finally{
            DAO.close(conn, ps, null);
        }
    }
}