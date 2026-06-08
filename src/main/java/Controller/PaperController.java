package Controller;
import Service.PapaerService;
import entity.paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/paper")
@CrossOrigin(origins = "*")
public class PaperController {

    @Autowired
    private PapaerService paperService;


    private Map<String, Object> result(int code, String msg, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    //查询所有试卷
    @GetMapping("/list")
    public Map<String, Object> list() {
        List<paper> list = paperService.getAllPapers();
        return result(200, "查询成功", list);
    }

    //根据id查询试卷
    @GetMapping("/{paperid}")
    public Map<String, Object> getById(@PathVariable int paperid) {
        paper p = paperService.getPaper(paperid);
        if (p == null) {
            return result(404, "试卷不存在", null);
        }
        return result(200, "查询成功", p);
    }

    //根据名称查询试卷
    @GetMapping("/title/{papertitle}")
    public Map<String, Object> getByTitle(@PathVariable String papertitle) {
        paper p = paperService.getPaperByTitle(papertitle);
        if (p == null) {
            return result(404, "试卷不存在", null);
        }
        return result(200, "查询成功", p);
    }

    //添加试卷
    @PostMapping
    public Map<String, Object> add(@RequestBody paper paper) {
        try {
            int rows = paperService.addPaper(paper);
            if (rows > 0) {
                return result(200, "添加成功", null);
            }
            return result(500, "添加失败", null);
        } catch (Exception e) {
            return result(500, "添加失败: " + e.getMessage(), null);
        }
    }

    //根据id删除试卷
    @DeleteMapping("/{paperid}")
    public Map<String, Object> deleteById(@PathVariable int paperid) {
        int rows = paperService.deletePaperById(paperid);
        if (rows > 0) {
            return result(200, "删除成功", null);
        }
        return result(404, "试卷不存在", null);
    }

    //根据名称删除试卷
    @DeleteMapping("/title/{papertitle}")
    public Map<String, Object> deleteByTitle(@PathVariable String papertitle) {
        int rows = paperService.deletePaperByTitle(papertitle);
        if (rows > 0) {
            return result(200, "删除成功", null);
        }
        return result(404, "试卷不存在", null);
    }

    //更新平均分
    @PutMapping("/avg/{paperid}")
    public Map<String, Object> updateAvg(@PathVariable int paperid) {
        try {
            int rows = paperService.updateAvg(paperid);
            if (rows > 0) {
                return result(200, "更新成功", null);
            }
            return result(404, "试卷不存在", null);
        } catch (Exception e) {
            return result(500, "更新失败: " + e.getMessage(), null);
        }
    }
}
