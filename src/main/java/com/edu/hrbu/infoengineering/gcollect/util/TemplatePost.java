package com.edu.hrbu.infoengineering.gcollect.util;
import com.edu.hrbu.infoengineering.gcollect.bean.*;
import com.edu.hrbu.infoengineering.gcollect.dao.*;
import com.edu.hrbu.infoengineering.gcollect.impl.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class TemplatePost {
    public static void deal(HttpServletRequest req){
        HttpSession session = req.getSession(true);
        Account operator = (Account)session.getAttribute("account");
        ArrayList<Account> allowedAl = new AccountImpl().getList(operator);
        Set<Integer> allowedId = new HashSet<>();
        for(Account a:allowedAl){allowedId.add(a.getAccountId());}
        HashMap<String,String> params = Params.get(req);
        Boolean status = false; // 默认操作失败
        boolean isFinished = false;
        String table = params.get("Table");
        String method = params.get("action");
        String message = "未知错误，请联系管理员";
        String messageType = "warning";
        if(!isFinished && table == null){isFinished = true;message = "请检查表名是否正确";}
        if(!isFinished && method == null){isFinished = true;message = "请检查操作方法是否正确";}
        if(!isFinished){
            System.out.println(table);
            if(!table.equals("admin")) {
                if(!allowedId.contains(Integer.parseInt(params.get("accountId")))) {
                    System.out.println(allowedId);
                    isFinished = true;message = "您没有该账户的操作权限";
                }
            }else{
                System.out.println(Integer.parseInt(params.get("accountAuthority")));
                System.out.println(operator.getAccountAuthority());
                if(Integer.parseInt(params.get("accountAuthority")) < operator.getAccountAuthority()) {
                    isFinished = true;message = "您不可以操作（创建/更新/删除）权限更高的账户";
                }
            }
        }
        if(!isFinished) {
            switch(table){
                case "admin":
                    Account account = new Account(params);
                    AccountDao accountDao = new AccountImpl();
                    switch (method) {
                        case "insert":
                            status = accountDao.insert(account);
                            message = status ? "创建账户成功" : "创建账户失败";
                            break;
                        case "update":
                            status = accountDao.update(account);
                            message = status ? "更新账户成功" : "更新账户失败";
                            break;
                        case "delete":
                            status = accountDao.delete(account);
                            message = status ? "删除账户成功" : "删除账户失败";
                            break;
                    }
                    break;
                case "paper":
                    Paper paper = new Paper(params);
                    PaperDao paperDao = new PaperImpl();
                    switch (method) {
                        case "insert":
                            status = paperDao.insert(paper,operator);
                            message = status ? "创建论文成功" : "创建论文失败";
                            break;
                        case "update":
                            status = paperDao.update(paper,operator);
                            message = status ? "更新论文成功" : "更新论文失败";
                            break;
                        case "delete":
                            status = paperDao.delete(paper,operator);
                            message = status ? "删除论文成功" : "删除论文失败";
                            break;
                    }
                    break;
                case "book":
                    Book book = new Book(params);
                    BookDao bookDao = new BookImpl();
                    switch (method) {
                        case "insert":
                            status = bookDao.insert(book, operator);
                            message = status ? "创建图书成功" : "创建图书失败";
                            break;
                        case "update":
                            status = bookDao.update(book, operator);
                            message = status ? "更新图书成功" : "更新图书失败";
                            break;
                        case "delete":
                            status = bookDao.delete(book, operator);
                            message = status ? "删除图书成功" : "删除图书失败";
                            break;
                    }
                    break;
                case "project":
                    Project project = new Project(params);
                    ProjectDao projectDao = new ProjectImpl();
                    switch (method) {
                        case "insert":
                            status = projectDao.insert(project, operator);
                            message = status ? "创建项目成功" : "创建项目失败";
                            break;
                        case "update":
                            status = projectDao.update(project, operator);
                            message = status ? "更新项目成功" : "更新项目失败";
                            break;
                        case "delete":
                            status = projectDao.delete(project, operator);
                            message = status ? "删除项目成功" : "删除项目失败";
                            break;
                    }
                    break;
                case "patent":
                    Patent patent = new Patent(params);
                    PatentDao patentDao = new PatentImpl();
                    switch (method) {
                        case "insert":
                            status = patentDao.insert(patent, operator);
                            message = status ? "创建专利成功" : "创建专利失败";
                            break;
                        case "update":
                            status = patentDao.update(patent, operator);
                            message = status ? "更新专利成功" : "更新专利失败";
                            break;
                        case "delete":
                            status = patentDao.delete(patent, operator);
                            message = status ? "删除专利成功" : "删除专利失败";
                            break;
                    }
                    break;
                case "copyright":
                    CopyRight copyRight = new CopyRight(params);
                    CopyRightDao copyRightDao = new CopyRightImpl();
                    switch (method) {
                        case "insert":
                            status = copyRightDao.insert(copyRight, operator);
                            message = status ? "创建软件著作权成功" : "创建软件著作权失败";
                            break;
                        case "update":
                            status = copyRightDao.update(copyRight, operator);
                            message = status ? "更新软件著作权成功" : "更新软件著作权失败";
                            break;
                        case "delete":
                            status = copyRightDao.delete(copyRight, operator);
                            message = status ? "删除软件著作权成功" : "删除软件著作权失败";
                            break;
                    }
                    break;
                case "achievement":
                    Achievement achievement = new Achievement(params);
                    AchievementDao achievementDao = new AchievementImpl();
                    switch (method) {
                        case "insert":
                            status = achievementDao.insert(achievement, operator);
                            message = status ? "创建成果奖励成功" : "创建成果奖励失败";
                            break;
                        case "update":
                            status = achievementDao.update(achievement, operator);
                            message = status ? "更新成果奖励成功" : "更新成果奖励失败";
                            break;
                        case "delete":
                            status = achievementDao.delete(achievement, operator);
                            message = status ? "删除成果奖励成功" : "删除成果奖励失败";
                            break;
                    }
                    break;
                case "stuproject":
                    StuProject stuProject = new StuProject(params);
                    StuProjectDao stuProjectDao = new StuProjectImpl();
                    switch (method) {
                        case "insert":
                            status = stuProjectDao.insert(stuProject, operator);
                            message = status ? "创建大创项目成功" : "创建大创项目失败";
                            break;
                        case "update":
                            status = stuProjectDao.update(stuProject, operator);
                            message = status ? "更新大创项目成功" : "更新大创项目失败";
                            break;
                        case "delete":
                            status = stuProjectDao.delete(stuProject, operator);
                            message = status ? "删除大创项目成功" : "删除大创项目失败";
                            break;
                    }
                    break;
                default:
                    message = "没有该类型的数据";
                    break;
            }
            isFinished = true;
        }
        message = (status ? "<strong>操作成功</strong>," : "<strong>操作失败</string>,") + message;
        if(status){
            switch (method){
                case "insert":
                    messageType = "info";
                    break;
                case "update":
                    messageType = "success";
                    break;
                case "delete":
                    messageType = "danger";
                    break;
            }
        }
        session.setAttribute("message",message);
        session.setAttribute("messageType",messageType);
    }
}