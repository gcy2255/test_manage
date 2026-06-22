/*
 Navicat Premium Dump SQL

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80044 (8.0.44)
 Source Host           : localhost:3306
 Source Schema         : testmanage

 Target Server Type    : MySQL
 Target Server Version : 80044 (8.0.44)
 File Encoding         : 65001

 Date: 22/06/2026 16:30:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `paperid` int NOT NULL AUTO_INCREMENT COMMENT '试卷ID',
  `papertitle` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '试卷标题',
  `paperdate` date NULL DEFAULT NULL COMMENT '考试日期',
  `person` int NULL DEFAULT 0 COMMENT '参加考试人数',
  `avg` double NULL DEFAULT 0 COMMENT '平均分',
  `total` double NULL DEFAULT 0 COMMENT '总分',
  PRIMARY KEY (`paperid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '试卷表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `student_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生姓名',
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `question_id` int NOT NULL COMMENT '题号',
  `paperid` int NOT NULL COMMENT '试卷ID',
  `student_id` int NOT NULL COMMENT '学生ID',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '题目类型',
  `question_score` double NULL DEFAULT 0 COMMENT '题目得分',
  PRIMARY KEY (`paperid`, `question_id`, `student_id`) USING BTREE,
  INDEX `student_id`(`student_id` ASC) USING BTREE,
  CONSTRAINT `test_ibfk_1` FOREIGN KEY (`paperid`) REFERENCES `paper` (`paperid`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `test_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '试卷题目得分表' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
