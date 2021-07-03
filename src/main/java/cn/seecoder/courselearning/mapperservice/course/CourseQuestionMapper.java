package cn.seecoder.courselearning.mapperservice.course;

import cn.seecoder.courselearning.po.course.CourseQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseQuestionMapper {
    int insert(CourseQuestion courseQuestion);

    List<CourseQuestion> selectByCourseId(Integer courseId);

    List<CourseQuestion> selectByTestIdWithAnswer(Integer testId);

    List<CourseQuestion> selectByTestIdNoAnswer(Integer testId);
}
