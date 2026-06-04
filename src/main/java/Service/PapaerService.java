package Service;

import entity.paper;
import Mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 试卷服务层
public class PapaerService {

    @Autowired
    private PaperMapper paperMapper;

    // 添加试卷
    public int addPaper(paper paper) {
        return paperMapper.addPaper(paper);
    }

    // 查询所有试卷
    public List<paper> getAllPapers() {
        return paperMapper.queryAll();
    }

    // 按照试卷的id查询试卷
    public paper getPaper(int paperid) {
        return paperMapper.queryPaperById(paperid);
    }

    // 按照试卷的名称查询试卷
    public paper getPaperByTitle(String papertitle) {
        return paperMapper.queryPaperByTitle(papertitle);
    }

    // 根据id删除试卷
    public int deletePaperById(int paperid) {
        return paperMapper.deletePaperById(paperid);
    }

    // 根据名称删除试卷
    public int deletePaperByTitle(String papertitle) {
        return paperMapper.deletePaperByTitle(papertitle);
    }

    // 计算试卷的平均成绩并且更新试卷的平均成绩
    public int updateAvg(int paperid) {
        paper paper = paperMapper.queryPaperById(paperid);
        double avg = 0.0;
        double total = paperMapper.getTotal(paperid);
        avg = total / paperMapper.getPerson(paperid);
        // 更新试卷的平均成绩
        return paperMapper.updateAvg(paperid, avg);
    }

}
