package cn.seecoder.courselearning.controller.course;

//import cn.seecoder.courselearning.service.course.CourseRentService;
import cn.seecoder.courselearning.service.course.CourseRentService;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.user.VipVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/student")
public class CourseRentController {
    @Resource
    CourseRentService courseRentService;


    /**
     * 判断某用户是否租用某课程
     */
    @GetMapping("/hasrent/{studentid}/{courseId}")
    public Integer HasRentCourse(@PathVariable Integer studentid,@PathVariable Integer courseId){
        return courseRentService.isRent(studentid,courseId);
    }

}
