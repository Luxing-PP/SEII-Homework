package cn.seecoder.courselearning.service.Test;

import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseQuestionVO;
import cn.seecoder.courselearning.vo.test.TestResultVO;
import cn.seecoder.courselearning.vo.test.TestVO;

import java.util.List;

public interface TestService {
    List<CourseQuestionVO> getAllQuestionByTestId(Integer testId);
    ResultVO<TestVO> createTest(TestVO testVO);
    List<TestVO> getAllTest(Integer courseId);
    ResultVO<TestVO> submitAnswer(Integer studentID,Integer testID,String answer);
    TestResultVO getTestResult(Integer studentID,Integer testID);
}
