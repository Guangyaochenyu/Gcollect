SET FOREIGN_KEY_CHECKS=0;

drop database if exists Gcollect;
create database Gcollect;
use Gcollect;

DROP TABLE IF EXISTS Account;
CREATE TABLE Account (
    AccountId int(11) NOT NULL AUTO_INCREMENT,
    AccountNumber char(255) NOT NULL,
    AccountPassword char(255) NOT NULL,
    AccountName char(255) NOT NULL,
    AccountAuthority int(11) NOT NULL DEFAULT '3',
    AccountPid char(255) DEFAULT NULL,
    AccountDepartment char(255) DEFAULT NULL,
    AccountTitle char(255) DEFAULT NULL,
    AccountConfirmBit int(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (AccountId),
    UNIQUE KEY AccountNumber (AccountNumber)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into Account values (1,'root','root','root',0,'230107200001010000','信工学院','超级管理员',1);
insert into Account values (2,'admin','admin','admin',0,'230107200001010001','信工学院','超级管理员',1);
insert into Account values (3,'20042134','20042134','张瑞来',1,'230107200001010002','信工学院','管理员',1);
insert into Account values (4,'20042120','20042120','田美怡',1,'230107200001010003','信工学院','管理员',1);

DROP TABLE IF EXISTS Achievement;
CREATE TABLE Achievement (
    AchievementId int(11) NOT NULL AUTO_INCREMENT,
    AccountId int(11) NOT NULL,
    AchievementName char(255) NOT NULL,
    AchievmentLevel char(255) NOT NULL,
    AchievementTime char(255) NOT NULL,
    AchievementRemark char(255) DEFAULT NULL,
    AchievementCreateUser int(11) NOT NULL,
    AchievementCreateTime datetime NOT NULL,
    AchievementUpdateUser int(11) NOT NULL,
    AchievementUpdateTime datetime NOT NULL,
    AchievementConfirmBit int(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (AchievementId),
    FOREIGN KEY (AccountId) REFERENCES Account (AccountId),
    FOREIGN KEY (AchievementCreateUser) REFERENCES Account (AccountId),
    FOREIGN KEY (AchievementUpdateUser) REFERENCES Account (AccountId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS Book;
CREATE TABLE Book (
    BookId int(11) NOT NULL AUTO_INCREMENT,
    AccountId int(11) NOT NULL,
    BookName char(255) NOT NULL,
    BookPublisher char(255) NOT NULL,
    BookPublishTime char(255) NOT NULL,
    BookIsbn char(255) NOT NULL,
    BookCategory char(255) NOT NULL,
    BookRole char(255) NOT NULL,
    BookAwardName char(255) DEFAULT NULL,
    BookAwardLevel char(255) DEFAULT NULL,
    BookAwardTime char(255) DEFAULT NULL,
    BookAwardUnit char(255) DEFAULT NULL,
    BookRemark char(255) DEFAULT NULL,
    BookCreateUser int(11) NOT NULL,
    BookCreateTime datetime NOT NULL,
    BookUpdateUser int(11) NOT NULL,
    BookUpdateTime datetime NOT NULL,
    BookConfirmBit int(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (BookId),
    FOREIGN KEY (AccountId) REFERENCES Account (AccountId),
    FOREIGN KEY (BookCreateUser) REFERENCES Account (AccountId),
    FOREIGN KEY (BookUpdateUser) REFERENCES Account (AccountId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS CopyRight;
CREATE TABLE CopyRight (
    CopyRightId int(11) NOT NULL AUTO_INCREMENT,
    AccountId int(11) NOT NULL,
    CopyRightName char(255) NOT NULL,
    CopyRightNumber char(255) DEFAULT NULL,
    CopyRightObtainTime char(255) DEFAULT NULL,
    CopyRightRemark char(255) DEFAULT NULL,
    CopyRightCreateUser int(11) NOT NULL,
    CopyRightCreateTime datetime NOT NULL,
    CopyRightUpdateUser int(11) NOT NULL,
    CopyRightUpdateTime datetime NOT NULL,
    CopyRightConfirmBit int(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (CopyRightId),
    FOREIGN KEY (AccountId) REFERENCES Account (AccountId),
    FOREIGN KEY (CopyRightCreateUser) REFERENCES Account (AccountId),
    FOREIGN KEY (CopyRightUpdateUser) REFERENCES Account (AccountId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS Paper;
CREATE TABLE Paper (
    PaperId int(11) NOT NULL AUTO_INCREMENT,
    AccountId int(11) NOT NULL,
    PaperName char(255) NOT NULL,
    PaperSource char(255) NOT NULL,
    PaperPublishTime char(255) NOT NULL,
    PaperCategory char(255) NOT NULL,
    PaperRole char(255) DEFAULT NULL,
    PaperAchieveType char(255) DEFAULT NULL,
    PaperAchieveLevel char(255) DEFAULT NULL,
    PaperAwardName char(255) DEFAULT NULL,
    PaperAwardLevel char(255) DEFAULT NULL,
    PaperAwardTime char(255) DEFAULT NULL,
    PaperAwardUnit char(255) DEFAULT NULL,
    PaperRemark char(255) DEFAULT NULL,
    PaperCreateUser int(11) NOT NULL,
    PaperCreateTime datetime NOT NULL,
    PaperUpdateUser int(11) NOT NULL,
    PaperUpdateTime datetime NOT NULL,
    PaperConfirmBit int(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (PaperId),
    FOREIGN KEY (AccountId) REFERENCES Account (AccountId),
    FOREIGN KEY (PaperCreateUser) REFERENCES Account (AccountId),
    FOREIGN KEY (PaperUpdateUser) REFERENCES Account (AccountId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS Patent;
CREATE TABLE Patent (
    PatentId int(11) NOT NULL AUTO_INCREMENT,
    AccountId int(11) NOT NULL,
    PatentName char(255) NOT NULL,
    PatentNumber char(255) NOT NULL,
    PatentType char(255) NOT NULL,
    PatentFilingTime char(255) DEFAULT NULL,
    PatentAcquisitionTime char(255) DEFAULT NULL,
    PatentRole char(255) DEFAULT NULL,
    PatentAwardName char(255) DEFAULT NULL,
    PatentAwardLevel char(255) DEFAULT NULL,
    PatentAwardTime char(255) DEFAULT NULL,
    PatentAwardUnit char(255) DEFAULT NULL,
    PatentRemark char(255) DEFAULT NULL,
    PatentCreateUser int(11) NOT NULL,
    PatentCreateTime datetime NOT NULL,
    PatentUpdateUser int(11) NOT NULL,
    PatentUpdateTime datetime NOT NULL,
    PatentConfirmBit int(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (PatentId),
    FOREIGN KEY (AccountId) REFERENCES Account (AccountId),
    FOREIGN KEY (PatentCreateUser) REFERENCES Account (AccountId),
    FOREIGN KEY (PatentUpdateUser) REFERENCES Account (AccountId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS Project;
CREATE TABLE Project (
    ProjectId int(11) NOT NULL AUTO_INCREMENT,
    AccountId int(11) NOT NULL,
    ProjectName char(255) NOT NULL,
    ProjectSource char(255) NOT NULL,
    ProjectNumber char(255) NOT NULL,
    ProjectStartTime char(255) DEFAULT NULL,
    ProjectEndTime char(255) DEFAULT NULL,
    ProjectFund int(11) DEFAULT NULL,
    ProjectAwardName char(255) DEFAULT NULL,
    ProjectAwardLevel char(255) DEFAULT NULL,
    ProjectAwardTime char(255) DEFAULT NULL,
    ProjectAwardUnit char(255) DEFAULT NULL,
    ProjectRemark char(255) DEFAULT NULL,
    ProjectCreateUser int(11) NOT NULL,
    ProjectCreateTime datetime NOT NULL,
    ProjectUpdateUser int(11) NOT NULL,
    ProjectUpdateTime datetime NOT NULL,
    ProjectConfirmBit int(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (ProjectId),
    FOREIGN KEY (AccountId) REFERENCES Account (AccountId),
    FOREIGN KEY (ProjectCreateUser) REFERENCES Account (AccountId),
    FOREIGN KEY (ProjectUpdateUser) REFERENCES Account (AccountId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS StuProject;
CREATE TABLE StuProject (
    StuProjectId int(11) NOT NULL AUTO_INCREMENT,
    AccountId int(11) NOT NULL,
    StuProjectNumber char(255) DEFAULT NULL,
    StuProjectName char(255) NOT NULL,
    StuProjectLeader char(255) NOT NULL,
    StuProjectCategory char(255) NOT NULL,
    StuProjectType char(255) NOT NULL,
    StuProjectRemark char(255) DEFAULT NULL,
    StuProjectCreateUser int(11) NOT NULL,
    StuProjectCreateTime datetime NOT NULL,
    StuProjectUpdateUser int(11) NOT NULL,
    StuProjectUpdateTime datetime NOT NULL,
    StuProjectConfirmBit int(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (StuProjectId),
    FOREIGN KEY (AccountId) REFERENCES Account (AccountId),
    FOREIGN KEY (StuProjectCreateUser) REFERENCES Account (AccountId),
    FOREIGN KEY (StuProjectUpdateUser) REFERENCES Account (AccountId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS=1;