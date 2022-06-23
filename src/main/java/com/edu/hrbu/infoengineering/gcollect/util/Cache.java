package com.edu.hrbu.infoengineering.gcollect.util;
import com.edu.hrbu.infoengineering.gcollect.bean.Account;
import com.edu.hrbu.infoengineering.gcollect.bean.Achievement;
import com.edu.hrbu.infoengineering.gcollect.bean.Book;
import com.edu.hrbu.infoengineering.gcollect.bean.CopyRight;
import com.edu.hrbu.infoengineering.gcollect.bean.Paper;
import com.edu.hrbu.infoengineering.gcollect.bean.Patent;
import com.edu.hrbu.infoengineering.gcollect.bean.Project;
import com.edu.hrbu.infoengineering.gcollect.bean.StuProject;
import com.edu.hrbu.infoengineering.gcollect.impl.AccountImpl;
import com.edu.hrbu.infoengineering.gcollect.impl.AchievementImpl;
import com.edu.hrbu.infoengineering.gcollect.impl.BookImpl;
import com.edu.hrbu.infoengineering.gcollect.impl.CopyRightImpl;
import com.edu.hrbu.infoengineering.gcollect.impl.PaperImpl;
import com.edu.hrbu.infoengineering.gcollect.impl.PatentImpl;
import com.edu.hrbu.infoengineering.gcollect.impl.ProjectImpl;
import com.edu.hrbu.infoengineering.gcollect.impl.StuProjectImpl;
import java.util.ArrayList;
public class Cache {
    // NeedUpdate: true if the cache is updated
    private Boolean AccountNeedUpdate = true;
    private Boolean AchievementNeedUpdate = true;
    private Boolean BookNeedUpdate = true;
    private Boolean CopyRightNeedUpdate = true;
    private Boolean PaperNeedUpdate = true;
    private Boolean PatentNeedUpdate = true;
    private Boolean ProjectNeedUpdate = true;
    private Boolean StuProjectNeedUpdate = true;
    private ArrayList<Account> AccountCache;
    private ArrayList<Achievement> AchievementCache;
    private ArrayList<Book> BookCache;
    private ArrayList<CopyRight> CopyRightCache;
    private ArrayList<Paper> PaperCache;
    private ArrayList<Patent> PatentCache;
    private ArrayList<Project> ProjectCache;
    private ArrayList<StuProject> StuProjectCache;
    private static volatile Cache instance = null;
    private Cache() {
        update("AccountNeedUpdate");
        update("AchievementNeedUpdate");
        update("BookNeedUpdate");
        update("CopyRightNeedUpdate");
        update("PaperNeedUpdate");
        update("PatentNeedUpdate");
        update("ProjectNeedUpdate");
        update("StuProjectNeedUpdate");
    }
    public static void load(){
        Cache.getInstance().getAllAccount();
        Cache.getInstance().getAllAchievement();
        Cache.getInstance().getAllBook();
        Cache.getInstance().getAllCopyRight();
        Cache.getInstance().getAllPaper();
        Cache.getInstance().getAllPatent();
        Cache.getInstance().getAllProject();
        Cache.getInstance().getAllStuProject();
    }
    public static Cache getInstance() {
        if (instance == null) {
            synchronized (Cache.class) {
                if (instance == null) {
                    instance = new Cache();
                }
            }
        }
        return instance;
    }
    public void update(String table){
        switch (table){
            case "Account":AccountNeedUpdate = true;break;
            case "Achievement":AchievementNeedUpdate = true;break;
            case "Book":BookNeedUpdate = true;break;
            case "CopyRight":CopyRightNeedUpdate = true;break;
            case "Paper":PaperNeedUpdate = true;break;
            case "Patent":PatentNeedUpdate = true;break;
            case "Project":ProjectNeedUpdate = true;break;
            case "StuProject":StuProjectNeedUpdate = true;break;
        }
    }
    public ArrayList<Account> getAllAccount(){
        if(AccountNeedUpdate){
            AccountCache = new AccountImpl().queryAll();
            AccountNeedUpdate = false;
        }
        return AccountCache;
    }
    public ArrayList<Achievement> getAllAchievement(){
        if(AchievementNeedUpdate){
            AchievementCache = new AchievementImpl().queryAll();
            AchievementNeedUpdate = false;
        }
        return AchievementCache;
    }
    public ArrayList<Book> getAllBook(){
        if(BookNeedUpdate){
            BookCache = new BookImpl().queryAll();
            BookNeedUpdate = false;
        }
        return BookCache;
    }
    public ArrayList<CopyRight> getAllCopyRight(){
        if(CopyRightNeedUpdate){
            CopyRightCache = new CopyRightImpl().queryAll();
            CopyRightNeedUpdate = false;
        }
        return CopyRightCache;
    }
    public ArrayList<Paper> getAllPaper(){
        if(PaperNeedUpdate){
            PaperCache = new PaperImpl().queryAll();
            PaperNeedUpdate = false;
        }
        return PaperCache;
    }
    public ArrayList<Patent> getAllPatent(){
        if(PatentNeedUpdate){
            PatentCache = new PatentImpl().queryAll();
            PatentNeedUpdate = false;
        }
        return PatentCache;
    }
    public ArrayList<Project> getAllProject(){
        if(ProjectNeedUpdate){
            ProjectCache = new ProjectImpl().queryAll();
            ProjectNeedUpdate = false;
        }
        return ProjectCache;
    }
    public ArrayList<StuProject> getAllStuProject(){
        if(StuProjectNeedUpdate){
            StuProjectCache = new StuProjectImpl().queryAll();
            StuProjectNeedUpdate = false;
        }
        return StuProjectCache;
    }
}