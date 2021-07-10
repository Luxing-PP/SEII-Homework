package cn.seecoder.courselearning.mapperservice.course;

import cn.seecoder.courselearning.po.course.CourseRent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseRentMapper {
    int insert(CourseRent courseRent);
    List<CourseRent> selectByStudentIdandCourseId(@Param("user_id")Integer user_id, @Param("course_id")Integer course_id );
}
