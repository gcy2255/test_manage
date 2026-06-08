package Mapper;

import entity.test;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestMapper {

    // 1. 插入一条分数记录
    @Insert("insert into test(question_id, paperid, student_id, type, question_score) " +
            "values(#{questionId}, #{paperid}, #{studentId}, #{type}, #{questionScore})")
    int insertScore(test test);

    // 2. 修改某学生某题的分数
    @Update("update test set question_score=#{questionScore} " +
            "where question_id=#{questionId} and paperid=#{paperid} and student_id=#{studentId}")
    int updateScore(int questionId, int paperid, int studentId, double questionScore);

    // 3. 重置某学生某题的分数为0
    @Update("update test set question_score=0 " +
            "where question_id=#{questionId} and paperid=#{paperid} and student_id=#{studentId}")
    int resetScore(int questionId, int paperid, int studentId);

    // 4. 查询某学生某题的分数
    @Select("select question_score from test " +
            "where question_id=#{questionId} and paperid=#{paperid} and student_id=#{studentId}")
    Double getScore(int questionId, int paperid, int studentId);

    // 5. 查询某张试卷某学生的所有题目得分（返回完整记录）
    @Select("select question_id as questionId, paperid, student_id as studentId, type, question_score as questionScore from test where paperid=#{paperid} and student_id=#{studentId}")
    List<test> getScoresByPaperAndStudent(int paperid, int studentId);

    // 6. 查询某张试卷所有学生的所有题目得分
    @Select("select question_id as questionId, paperid, student_id as studentId, type, question_score as questionScore from test where paperid=#{paperid}")
    List<test> getAllScoresByPaper(int paperid);

    // 7. 删除某学生某题的分数记录
    @Delete("delete from test where question_id=#{questionId} and paperid=#{paperid} and student_id=#{studentId}")
    int deleteScore(int questionId, int paperid, int studentId);
}
