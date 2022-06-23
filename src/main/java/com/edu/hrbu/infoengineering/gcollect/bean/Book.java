package com.edu.hrbu.infoengineering.gcollect.bean;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class Book {
    private int bookId;
    private int accountId;
    private String bookName;
    private String bookPublisher;
    private String bookPublishTime;
    private String bookIsbn;
    private String bookCategory;
    private String bookRole;
    private String bookAwardName;
    private String bookAwardLevel;
    private String bookAwardTime;
    private String bookAwardUnit;
    private String bookRemark;
    private int bookConfirmBit;
    public Book(){}
    public Book(HashMap<String,String> mp){
        this.bookId = Integer.parseInt(mp.get("bookId"));
        this.accountId = Integer.parseInt(mp.get("accountId"));
        this.bookName = mp.get("bookName");
        this.bookPublisher = mp.get("bookPublisher");
        this.bookPublishTime = mp.get("bookPublishTime");
        this.bookIsbn = mp.get("bookIsbn");
        this.bookCategory = mp.get("bookCategory");
        this.bookRole = mp.get("bookRole");
        this.bookAwardName = mp.get("bookAwardName");
        this.bookAwardLevel = mp.get("bookAwardLevel");
        this.bookAwardTime = mp.get("bookAwardTime");
        this.bookAwardUnit = mp.get("bookAwardUnit");
        this.bookRemark = mp.get("bookRemark");
    }
    public int getBookId() {return bookId;}
    public void setBookId(int bookId) {this.bookId = bookId;}
    public int getAccountId() {return accountId;}
    public void setAccountId(int accountId) {this.accountId = accountId;}
    public String getBookName() {return bookName;}
    public void setBookName(String bookName) {this.bookName = bookName;}
    public String getBookPublisher() {return bookPublisher;}
    public void setBookPublisher(String bookPublisher) {this.bookPublisher = bookPublisher;}
    public String getBookPublishTime() {return bookPublishTime;}
    public void setBookPublishTime(String bookPublishTime) {this.bookPublishTime = bookPublishTime;}
    public String getBookIsbn() {return bookIsbn;}
    public void setBookIsbn(String bookIsbn) {this.bookIsbn = bookIsbn;}
    public String getBookCategory() {return bookCategory;}
    public void setBookCategory(String bookCategory) {this.bookCategory = bookCategory;}
    public String getBookRole() {return bookRole;}
    public void setBookRole(String bookRole) {this.bookRole = bookRole;}
    public String getBookAwardName() {return bookAwardName;}
    public void setBookAwardName(String bookAwardName) {this.bookAwardName = bookAwardName;}
    public String getBookAwardLevel() {return bookAwardLevel;}
    public void setBookAwardLevel(String bookAwardLevel) {this.bookAwardLevel = bookAwardLevel;}
    public String getBookAwardTime() {return bookAwardTime;}
    public void setBookAwardTime(String bookAwardTime) {this.bookAwardTime = bookAwardTime;}
    public String getBookAwardUnit() {return bookAwardUnit;}
    public void setBookAwardUnit(String bookAwardUnit) {this.bookAwardUnit = bookAwardUnit;}
    public String getBookRemark() {return bookRemark;}
    public void setBookRemark(String bookRemark) {this.bookRemark = bookRemark;}
    public int getBookConfirmBit() {return bookConfirmBit;}
    public void setBookConfirmBit(int bookConfirmBit) {this.bookConfirmBit = bookConfirmBit;}
    @Override public String toString() {return "Book{"+bookId+","+accountId+","+bookName+","+bookPublisher+","+bookPublishTime+","+bookIsbn+","+bookCategory+","+bookRole+","+bookAwardName+","+bookAwardLevel+","+bookAwardTime+","+bookAwardUnit+","+bookRemark+","+bookConfirmBit+"}";}
    public static JSONObject translate() {
        JSONObject json = new JSONObject(true);
        json.put("bookId", "图书ID");
        json.put("accountId", "用户ID");
        json.put("bookName", "名称");
        json.put("bookPublisher", "出版社");
        json.put("bookPublishTime", "出版时间");
        json.put("bookIsbn", "ISBN");
        json.put("bookCategory", "类别");
        json.put("bookRole", "角色");
        json.put("bookAwardName", "获奖名称");
        json.put("bookAwardLevel", "获奖等级");
        json.put("bookAwardTime", "获奖时间");
        json.put("bookAwardUnit", "获奖单位");
        json.put("bookRemark", "备注");
        json.put("bookConfirmBit", "确认位");
        return json;
    }
    public JSONObject toJSON(){
        JSONObject json = new JSONObject(true);
        json.put("bookId", bookId);
        json.put("accountId", accountId);
        json.put("bookName", bookName);
        json.put("bookPublisher", bookPublisher);
        json.put("bookPublishTime", bookPublishTime);
        json.put("bookIsbn", bookIsbn);
        json.put("bookCategory", bookCategory);
        json.put("bookRole", bookRole);
        json.put("bookAwardName", bookAwardName);
        json.put("bookAwardLevel", bookAwardLevel);
        json.put("bookAwardTime", bookAwardTime);
        json.put("bookAwardUnit", bookAwardUnit);
        json.put("bookRemark", bookRemark);
        json.put("bookConfirmBit", bookConfirmBit);
        if(bookConfirmBit==-1){
            json.put("bookId",json.getString("bookId")+"(已删除)");
        }
        return json;
    }
    public static JSONArray toJSON(ArrayList<Book> books) {
        JSONArray json = new JSONArray();
        json.add(Book.translate());
        for (Book book : books) {json.add(book.toJSON());}
        return json;
    }
}