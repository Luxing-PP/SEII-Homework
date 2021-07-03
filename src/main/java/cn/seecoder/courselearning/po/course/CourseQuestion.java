package cn.seecoder.courselearning.po.course;

import java.util.List;

public class CourseQuestion {
    private Integer id;
    private Integer course_id;
    private Integer answer_id;
    /**
     * 题干
     */
    private String description;
    private String correct_answer;
    /**
     * 解析
     */
    private String explain;

    public CourseQuestion(){

    };

    public CourseQuestion(int course_id, int answer_id, String description){
        //用于插入
        this.course_id = course_id;
        this.answer_id = answer_id;
        this.description = description;
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

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
