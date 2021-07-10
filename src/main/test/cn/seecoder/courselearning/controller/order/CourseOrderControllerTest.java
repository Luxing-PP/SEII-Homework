package cn.seecoder.courselearning.controller.order;

import cn.seecoder.courselearning.controller.test.TestController;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseOrderControllerTest {
    private CourseOrderController courseOrderController;

    @BeforeEach
    public void before(@Autowired CourseOrderController courseOrderController){ this.courseOrderController = courseOrderController; }
    public
    @Test
    void createRentCourseOrder() {
        courseOrderController.createRentCourseOrder(1,1);
        courseOrderController.payOrder(1);
    }
    @Test
    void vipOrder(){
        courseOrderController.createVipOrder(2);
        System.out.println(courseOrderController.payOrder(1));
    }
}