package entity;

import lombok.Data;

import java.time.LocalDate;

//一张试卷的实体包括试卷id，试卷名称，创建日期，参加考试人数，平均分
@Data
public class paper {
    private int  paperid;
    private String papertitle;
    private LocalDate paperdate;
    private int person;
    private double avg;
    private double total;
}
