package cn.seecoder.courselearning.vo.test;

import cn.seecoder.courselearning.po.test.Test;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class TestVO {
    private Integer id;
    private Integer course_id;
    private List<Integer> questionList;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private String tname;

    public TestVO(Test test){
        this.tname=test.getTname();
        this.id = test.getId();
        this.course_id = test.getCourse_id();
        this.questionList = test.getQuestionList();
        this.start_time = test.getStart_time();
        this.end_time = test.getEnd_time();
    }
    public TestVO(){}

    public List<Integer> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Integer> questionList) {
        this.questionList = questionList;
    }
}
