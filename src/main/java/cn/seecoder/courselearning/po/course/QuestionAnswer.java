package cn.seecoder.courselearning.po.course;

public class QuestionAnswer {
    private Integer id;
    private String correct_answer;
    private String explain;

    public QuestionAnswer(){};
    public QuestionAnswer(String correct_answer,String explain){
        this.correct_answer=correct_answer;
        this.explain=explain;
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
