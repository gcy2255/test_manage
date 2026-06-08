package entity;

import lombok.Data;

//每张试卷的具体每题得分情况（按学生区分）
@Data
public class test {
    private int question_id; // 题号
    private int paperid;     // 关联paper表
    private int studentId;   // 关联student表
    private String type;     // 题目类型
    private double question_score; // 题目得分
}
