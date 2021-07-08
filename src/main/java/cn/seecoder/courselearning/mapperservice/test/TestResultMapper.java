package cn.seecoder.courselearning.mapperservice.test;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestResultMapper {
    int insertResultList(@Param("test_id") Integer test_id, @Param("student_id") Integer student_id,@Param("answer") String answer);
}
