package cn.seecoder.courselearning.controller.course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseVIPControllerTest {
    private CourseVIPController courseVIPController;
    @BeforeEach
    public void before(@Autowired CourseVIPController courseVIPController){ this.courseVIPController = courseVIPController; }
    @Test
    void isVip() {
        System.out.println(courseVIPController.isVip(1));
        assert (courseVIPController.isVip(1)==1);
        System.out.println(courseVIPController.isVip(2));
        assert (courseVIPController.isVip(2)==0);
    }
}