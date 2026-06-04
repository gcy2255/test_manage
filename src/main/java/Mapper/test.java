package Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface test {
    /*
    分为两部分
    一部分是单张试卷的设置部分设置增加试卷（按照用户自定义数据增加题目数量增加题目类型设置题号）
    第二部分是单张试卷的
    单张试卷的录分部分就是添加某一题号的分数
     */
    //1.添加试卷
    //返回值为添加的试卷的id
    @Insert(
            "insert into test (count,question_id,paperid,type,question_score) values (#{test.count},#{test.question_id},#{test.paperid},#{test.type},#{test.question_score})"
               )
    int addPaper(test test);

    //2.添加试卷的录分部分
    //返回值为添加的试卷的id
    @Insert("insert into test (question_id,question_score) values (#{test.question_id},#{test.question_score})")
    int addScore(test test);
}
