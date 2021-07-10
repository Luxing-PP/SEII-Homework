package cn.seecoder.courselearning.po.course;

import java.time.LocalDateTime;

public class CourseRent {
    private Integer id;
    private Integer student_id;
    private Integer course_id;
    private LocalDateTime start_time;
    private LocalDateTime end_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd__time(LocalDateTime end_time) {
        this.end_time = end_time;
    }
}
