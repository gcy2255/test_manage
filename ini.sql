-- ============================================
-- 试卷管理系统 - 数据库初始化脚本
-- ============================================

-- 删除旧数据库（如果存在）
DROP DATABASE IF EXISTS papertest;

-- 创建数据库
CREATE DATABASE papertest DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE papertest;

-- 删除已有表（按依赖顺序）
DROP TABLE IF EXISTS test;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS paper;

-- ============================================
-- 1. 试卷表 (paper)
-- ============================================
CREATE TABLE paper (
    paperid     INT PRIMARY KEY AUTO_INCREMENT COMMENT '试卷ID',
    papertitle  VARCHAR(200) NOT NULL COMMENT '试卷标题',
    paperdate   DATE COMMENT '考试日期',
    person      INT DEFAULT 0 COMMENT '参加考试人数',
    avg         DOUBLE DEFAULT 0 COMMENT '平均分',
    total       DOUBLE DEFAULT 0 COMMENT '总分',
    count       INT DEFAULT 0 COMMENT '题目数量'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='试卷表';

-- ============================================
-- 2. 学生表 (student)
-- ============================================
CREATE TABLE student (
    student_id    INT PRIMARY KEY AUTO_INCREMENT COMMENT '学生ID',
    student_name  VARCHAR(100) NOT NULL COMMENT '学生姓名'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生表';

-- ============================================
-- 3. 试卷题目得分表 (test)
-- ============================================
CREATE TABLE test (
    question_id    INT NOT NULL COMMENT '题号',
    paperid        INT NOT NULL COMMENT '试卷ID',
    student_id     INT NOT NULL COMMENT '学生ID',
    type           VARCHAR(50) COMMENT '题目类型',
    question_score DOUBLE DEFAULT 0 COMMENT '题目得分',
    PRIMARY KEY (paperid, question_id, student_id),
    FOREIGN KEY (paperid) REFERENCES paper(paperid) ON DELETE CASCADE,
    FOREIGN KEY (student_id) REFERENCES student(student_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='试卷题目得分表';
