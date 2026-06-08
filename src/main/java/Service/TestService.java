package Service;

import Mapper.PaperMapper;
import Mapper.TestMapper;
import entity.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private PaperMapper paperMapper;

    // 1. 插入一条分数记录
    public int insertScore(test test) {
        return testMapper.insertScore(test);
    }

    // 2. 修改分数
    public int updateScore(int question_id, int paperid, int studentId, double question_score) {
        return testMapper.updateScore(question_id, paperid, studentId, question_score);
    }

    // 3. 重置分数为0
    public int resetScore(int question_id, int paperid, int studentId) {
        return testMapper.resetScore(question_id, paperid, studentId);
    }

    // 4. 查询单题分数
    public Double getScore(int question_id, int paperid, int studentId) {
        return testMapper.getScore(question_id, paperid, studentId);
    }

    // 5. 查询某学生在某试卷的所有题目得分
    public List<test> getScoresByPaperAndStudent(int paperid, int studentId) {
        return testMapper.getScoresByPaperAndStudent(paperid, studentId);
    }

    // 6. 查询某试卷所有学生的所有得分
    public List<test> getAllScoresByPaper(int paperid) {
        return testMapper.getAllScoresByPaper(paperid);
    }

    // 7. 删除分数记录
    public int deleteScore(int question_id, int paperid, int studentId) {
        return testMapper.deleteScore(question_id, paperid, studentId);
    }
}
