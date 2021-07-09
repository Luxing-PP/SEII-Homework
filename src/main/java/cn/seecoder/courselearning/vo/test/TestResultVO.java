package cn.seecoder.courselearning.vo.test;

import cn.seecoder.courselearning.po.test.TestResult;
import lombok.Data;
import lombok.NonNull;

@Data
public class TestResultVO {
    private Integer id;
    private Integer test_id;
    private Integer user_id;
    private String user_answer;
    private Double user_score;
    public TestResultVO(@NonNull TestResult testResult){
        id=testResult.getId();
        test_id=testResult.getTest_id();
        user_id=testResult.getUser_id();
        user_answer=testResult.getUser_answer();
        user_score=testResult.getUser_score();
    }
}
