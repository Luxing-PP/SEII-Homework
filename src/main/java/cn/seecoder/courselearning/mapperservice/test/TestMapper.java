package cn.seecoder.courselearning.mapperservice.test;

import cn.seecoder.courselearning.po.course.CourseWare;
import cn.seecoder.courselearning.po.test.Test;

import java.util.List;

public interface TestMapper {
    int insert(Test record);
    List<Test> selectByCourseId(Integer courseId);
    Test selectByPrimaryKey(Integer id);
}
