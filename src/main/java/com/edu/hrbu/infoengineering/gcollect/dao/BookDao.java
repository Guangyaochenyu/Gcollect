package com.edu.hrbu.infoengineering.gcollect.dao;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Book;
import java.util.ArrayList;
public interface BookDao {
    public abstract ArrayList<Book> getList(Account account);
    public abstract ArrayList<Book> queryAll();
    public abstract ArrayList<Book> queryList(Account account);
    public abstract ArrayList<Book> queryEffective(Account account);
    public abstract Boolean insert(Book book, Account account);
    public abstract Boolean update(Book book, Account account);
    public abstract Boolean delete(Book book, Account account);
}