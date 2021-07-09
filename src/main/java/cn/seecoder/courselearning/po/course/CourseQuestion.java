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

    /**
     * 四个选项
     */
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    public CourseQuestion(){

    };

    public CourseQuestion(Integer course_id, Integer answer_id, String description, String optionA, String optionB, String optionC, String optionD) {
        this.course_id = course_id;
        this.answer_id = answer_id;
        this.description = description;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
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

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
}
