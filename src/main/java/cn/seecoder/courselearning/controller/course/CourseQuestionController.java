package cn.seecoder.courselearning.controller.course;

import cn.seecoder.courselearning.po.course.CourseQuestion;
import cn.seecoder.courselearning.service.course.CourseQuestionService;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseQuestionVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/course_question")
public class CourseQuestionController {
    @Resource
    private CourseQuestionService courseQuestionService;

    @PostMapping("/create")
    public ResultVO<CourseQuestionVO> createQuestion(@RequestBody CourseQuestionVO courseQuestionVO){
        return courseQuestionService.create(courseQuestionVO);
    }

    @GetMapping("/getAll/{courseID}")
    public List<CourseQuestionVO> getAllQuestionByCourseID(@PathVariable Integer courseID){
        return courseQuestionService.getAllQuestionByCourseID(courseID);
    }
}
