package cn.seecoder.courselearning.controller.test;

import cn.seecoder.courselearning.po.course.CourseQuestion;
import cn.seecoder.courselearning.po.test.Test;
import cn.seecoder.courselearning.service.Test.TestService;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseQuestionVO;
import cn.seecoder.courselearning.vo.test.TestVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    TestService testService;

    @PostMapping("/create")
    public ResultVO<TestVO> createTest(@RequestBody TestVO testVO){
        return testService.createTest(testVO);
    }

    @GetMapping("/getAllTest/{courseID}")
    public List<TestVO> getAllTest(@PathVariable Integer courseID){
        //todo
        //搞定了（也许吧）——cjw
        return testService.getAllTest(courseID);
    }

    @GetMapping("/getAllQuestion/{testID}")
    public List<CourseQuestionVO> getAllQuestionByTestId(@PathVariable Integer testID){
        return testService.getAllQuestionByTestId(testID);
    }


    @PostMapping("/submit/{studentID}/{testID}")
    public ResultVO<TestVO> submitAnswer(@PathVariable Integer studentID,
                                         @PathVariable Integer testID,
                                         @RequestParam String answer){
        //todo 这个我就没搞懂HH
        return null;
    }
}
