package entity;

import lombok.Data;
//每张试卷的具体每题得分情况，
@Data
public class test {
    private int count;//题目数量
    private int question_id;//主键题号
    private int paperid; //paperid关联paper表
    private String type; //题目类型
    private double question_score;//题目得分
}
