-- 创建数据库
CREATE DATABASE papertest;
USE papertest;
-- 试卷表
CREATE TABLE IF NOT EXISTS paper (
    paperid     INT PRIMARY KEY,
    papertitle  VARCHAR(200) NOT NULL,
    paperdate   DATE,
    person      INT DEFAULT 0,
    avg         DOUBLE DEFAULT 0,
    total       DOUBLE DEFAULT 0
);

-- 试卷题目/得分表
CREATE TABLE IF NOT EXISTS test (
    count           INT DEFAULT 0,
    question_id     INT,
    paperid         INT,
    type            VARCHAR(50),
    question_score  DOUBLE DEFAULT 0,
    PRIMARY KEY (question_id, paperid),
    FOREIGN KEY (paperid) REFERENCES paper(paperid) ON DELETE CASCADE
);
