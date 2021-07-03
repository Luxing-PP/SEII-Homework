package cn.seecoder.courselearning.vo.course;

import cn.seecoder.courselearning.po.course.CourseQuestion;
import lombok.Data;


public class CourseQuestionVO {
    private Integer id;
    private Integer course_id;
    /**
     * 题干
     */
    private String description;
    /**
     * 依照结束没有，可能不存在
     */
    private String correct_answer;
    /**
     * 解析，依照结束没有，可能不存在
     */
    private String explain;

    public CourseQuestionVO(){};
    public CourseQuestionVO(CourseQuestion courseQuestion){
        this.id = courseQuestion.getId();
        this.course_id = courseQuestion.getCourse_id();
        this.description = courseQuestion.getDescription();
        this.correct_answer = courseQuestion.getCorrect_answer();
        this.explain = courseQuestion.getExplain();
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
