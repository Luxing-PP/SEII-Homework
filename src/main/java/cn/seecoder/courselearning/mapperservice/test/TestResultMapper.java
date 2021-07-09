package cn.seecoder.courselearning.mapperservice.test;

import cn.seecoder.courselearning.po.test.TestResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestResultMapper {
    int insertResultList(@Param("test_id") Integer test_id, @Param("student_id") Integer student_id,@Param("answer") String answer,@Param("score") double score);
    List<TestResult> selectByTestIdAndStudentId(@Param("user_id")Integer user_id,@Param("test_id")Integer test_id);
}
