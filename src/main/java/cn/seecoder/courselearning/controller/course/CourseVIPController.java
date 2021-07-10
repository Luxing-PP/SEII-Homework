package cn.seecoder.courselearning.controller.course;

import cn.seecoder.courselearning.service.course.CourseRentService;
import cn.seecoder.courselearning.service.user.VipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@RequestMapping("/student")
public class CourseVIPController {
    @Resource
    VipService vipService;


    @GetMapping("/isVip/{student_id}")
    public Integer isVip(@PathVariable Integer student_id){
        return vipService.isVip(student_id);
    }

}
