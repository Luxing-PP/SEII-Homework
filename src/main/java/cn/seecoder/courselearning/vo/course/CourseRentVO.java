package cn.seecoder.courselearning.vo.course;

import cn.seecoder.courselearning.po.course.CourseRent;

import java.time.LocalDateTime;

public class CourseRentVO {
    private Integer id;
    private Integer student_id;
    private Integer course_id;
    private LocalDateTime start_time;
    private LocalDateTime end__time;

    public CourseRentVO(CourseRent courseRent){
        id=courseRent.getId();
        student_id=courseRent.getStudent_id();
        course_id=courseRent.getCourse_id();
        start_time=courseRent.getStart_time();
        end__time=courseRent.getEnd_time();
    }
}
