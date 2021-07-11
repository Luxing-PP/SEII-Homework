package cn.seecoder.courselearning.serviceimpl.course;

import cn.seecoder.courselearning.mapperservice.course.CourseRentMapper;
import cn.seecoder.courselearning.po.course.CourseRent;
import cn.seecoder.courselearning.service.course.CourseRentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseRentServiceImpl implements CourseRentService {
    @Resource
    CourseRentMapper courseRentMapper;
    @Override
    public Integer isRent(Integer student_id, Integer course_id) {
        List<CourseRent> courseRent=courseRentMapper.selectByStudentIdandCourseId(student_id,course_id);
        if (courseRent.size()>=1) {
            for (CourseRent rent : courseRent) {
                //判断是否已经过了租期租期
                if (rent.getEnd_time().isAfter(LocalDateTime.now()))
                    return 1;
            }
        }
        //无租用记录或已过租期返回无效
        return 0;
    }
}
