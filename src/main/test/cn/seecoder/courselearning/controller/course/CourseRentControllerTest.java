package cn.seecoder.courselearning.controller.course;

import cn.seecoder.courselearning.controller.order.CourseOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRentControllerTest {
    private CourseRentController courseRentController;
    @BeforeEach
    public void before(@Autowired CourseRentController courseRentController){ this.courseRentController = courseRentController; }
    @Test
    void createRentCourseOrder() {
        System.out.println(courseRentController.HasRentCourse(1,3));
        System.out.println(courseRentController.HasRentCourse(1,1));
        System.out.println(courseRentController.HasRentCourse(1,2));
        assert (courseRentController.HasRentCourse(1,3)==1);
        assert (courseRentController.HasRentCourse(1,1)==0);
        assert (courseRentController.HasRentCourse(1,2)==0);
    }
}