package Controller;

import Service.TestService;
import entity.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*")
public class TestController {

    @Autowired
    private TestService testService;

    private Map<String, Object> result(int code, String msg, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    // 插入一条分数记录
    @PostMapping
    public Map<String, Object> insert(@RequestBody test test) {
        try {
            int rows = testService.insertScore(test);
            if (rows > 0) {
                return result(200, "录入成功", null);
            }
            return result(500, "录入失败", null);
        } catch (Exception e) {
            return result(500, "录入失败: " + e.getMessage(), null);
        }
    }

    // 修改分数
    @PutMapping
    public Map<String, Object> update(@RequestBody test test) {
        try {
            int rows = testService.updateScore(
                    test.getQuestion_id(), test.getPaperid(),
                    test.getStudentId(), test.getQuestion_score());
            if (rows > 0) {
                return result(200, "修改成功", null);
            }
            return result(404, "记录不存在", null);
        } catch (Exception e) {
            return result(500, "修改失败: " + e.getMessage(), null);
        }
    }

    // 删除分数记录
    @DeleteMapping("/{paperid}/{questionId}/{studentId}")
    public Map<String, Object> delete(@PathVariable int paperid,
                                       @PathVariable int questionId,
                                       @PathVariable int studentId) {
        int rows = testService.deleteScore(questionId, paperid, studentId);
        if (rows > 0) {
            return result(200, "删除成功", null);
        }
        return result(404, "记录不存在", null);
    }

    // 查询某试卷某学生的某题分数
    @GetMapping("/{paperid}/{questionId}/{studentId}")
    public Map<String, Object> getOne(@PathVariable int paperid,
                                       @PathVariable int questionId,
                                       @PathVariable int studentId) {
        Double score = testService.getScore(questionId, paperid, studentId);
        if (score != null) {
            return result(200, "查询成功", score);
        }
        return result(404, "记录不存在", null);
    }

    // 查询某试卷某学生的所有题目得分
    @GetMapping("/{paperid}/student/{studentId}")
    public Map<String, Object> getByPaperAndStudent(@PathVariable int paperid,
                                                      @PathVariable int studentId) {
        List<test> list = testService.getScoresByPaperAndStudent(paperid, studentId);
        return result(200, "查询成功", list);
    }

    // 查询某试卷所有学生的所有得分
    @GetMapping("/{paperid}")
    public Map<String, Object> getAllByPaper(@PathVariable int paperid) {
        List<test> list = testService.getAllScoresByPaper(paperid);
        return result(200, "查询成功", list);
    }
}
