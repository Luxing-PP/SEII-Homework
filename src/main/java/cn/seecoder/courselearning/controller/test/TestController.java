package cn.seecoder.courselearning.controller.test;

import cn.seecoder.courselearning.po.course.CourseQuestion;
import cn.seecoder.courselearning.po.test.Test;
import cn.seecoder.courselearning.service.Test.TestService;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseQuestionVO;
import cn.seecoder.courselearning.vo.test.TestResultVO;
import cn.seecoder.courselearning.vo.test.TestVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    TestService testService;


    /**
     * 创建测试
     */
    @PostMapping("/create")
    public ResultVO<TestVO> createTest(@RequestBody TestVO testVO){
        return testService.createTest(testVO);
    }


    /**
     * 获取测试列表
     */
    @GetMapping("/getAllTest/{courseID}")
    public List<TestVO> getAllTest(@PathVariable Integer courseID){
        return testService.getAllTest(courseID);
    }

    @GetMapping("/getAllQuestion/{testID}")
    public List<CourseQuestionVO> getAllQuestionByTestId(@PathVariable Integer testID){
        return testService.getAllQuestionByTestId(testID);
    }


    /**
     * 学生用户提交测试答案
     */
    @PostMapping("/submit/{studentID}/{testID}")
    public ResultVO<TestVO> submitAnswer(@PathVariable Integer studentID,
                                         @PathVariable Integer testID,
                                         @RequestParam String answer){
        return testService.submitAnswer(studentID,testID,answer);
    }

    /**
     * 获取某用户的测试分数
     */
    @GetMapping("/getTestResult/{testID}/{studentID}")
    public TestResultVO getTestResult(@PathVariable Integer studentID,
                                      @PathVariable Integer testID){

        System.out.println("------------------**************");
        System.out.println("studentid: " +  studentID);
        System.out.println(testID);
        TestResultVO testResultVO = testService.getTestResult(studentID,testID);
        System.out.println(testResultVO.getUser_answer());
        return testResultVO;
    }
}
