package Mapper;

import entity.paper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaperMapper {

    /*
    接口方法操作paper
           1.添加试卷
           2.删除试卷
                1.根据试卷id删除试卷
                2.根据试卷名称删除试卷
           3.查询试卷
                1.根据试卷id查询试卷
                2.根据试卷名称查询试卷
     */

    // 添加试卷
    @Insert(
            "insert into paper(paperid,papertitle,paperdate,person,avg,total,count) values(#{paperid},#{papertitle},#{paperdate},#{person},#{avg},#{total},#{count})"
    )
    int addPaper(paper paper);

    /*
    删除试卷
    1.根据试卷id删除试卷
    2.根据试卷名称删除试卷
     */

    @Delete(
            "delete from paper where paperid=#{paperid}"
    )
    int deletePaperById(int paperid);

    @Delete(
            "delete from paper where papertitle=#{papertitle}"
    )
    int deletePaperByTitle(String papertitle);

    /*
    查询试卷
    1.根据试卷id查询试卷
    2.根据试卷名称查询试卷
     */
    @Select(
            "select * from paper where paperid=#{paperid}"
    )
    paper queryPaperById(int paperid);

    @Select(
            "select * from paper where papertitle=#{papertitle}"
    )
    paper queryPaperByTitle(String papertitle);

    // getTotal
    @Select(
            "select total from paper where paperid=#{paperid}"
    )
    double getTotal(int paperid);

    // 计算试卷的平均成绩并且更新试卷的平均成绩
    @Update(
            "update paper set avg=#{avg} where paperid=#{paperid}"
    )
    int updateAvg(int paperid, double avg);

    // getPerson
    @Select(
            "select person from paper where paperid=#{paperid}"
    )
    int getPerson(int paperid);

    // 查询所有试卷
    @Select("select * from paper")
    List<paper> queryAll();
}
