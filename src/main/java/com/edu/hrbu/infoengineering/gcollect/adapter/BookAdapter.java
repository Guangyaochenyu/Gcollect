package com.edu.hrbu.infoengineering.gcollect.adapter;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Book;
import com.edu.hrbu.infoengineering.gcollect.dao.BookDao;
import java.util.ArrayList;
public class BookAdapter implements BookDao {
    @Override public ArrayList<Book> getList(Account account){return null;}
    @Override public ArrayList<Book> queryAll(){return null;}
    @Override public ArrayList<Book> queryList(Account account){return null;}
    @Override public ArrayList<Book> queryEffective(Account account){return null;}
    @Override public Boolean insert(Book book, Account account){return null;}
    @Override public Boolean update(Book book, Account account){return null;}
    @Override public Boolean delete(Book book, Account account){return null;}
}