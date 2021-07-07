package cn.seecoder.courselearning.po.test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Test {
    private Integer id;
    private Integer course_id;
    private List<Integer> questionList;
    private LocalDateTime start_time;
    private LocalDateTime end_time;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    private String tname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public List<Integer> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Integer> questionList) {
        this.questionList = questionList;
    }
}
