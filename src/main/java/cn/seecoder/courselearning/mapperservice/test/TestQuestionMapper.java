package cn.seecoder.courselearning.mapperservice.test;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestQuestionMapper {
    int insertQuestionList(@Param("test_id") Integer test_id, @Param("qidList") List<Integer> qidList);
}
