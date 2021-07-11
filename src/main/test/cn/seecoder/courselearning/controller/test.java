package cn.seecoder.courselearning.controller;
import cn.seecoder.courselearning.controller.test.TestController;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseQuestionVO;
import cn.seecoder.courselearning.vo.test.TestResultVO;
import cn.seecoder.courselearning.vo.test.TestVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootTest
class TestControllerTest {

    private TestController testController;

    @BeforeEach
    public void before(@Autowired TestController testController){ this.testController = testController; }

    @Test
    void createTest() {
        TestVO testVO = new TestVO();
        LocalDateTime s=LocalDateTime.of(2021,11,11,10,0);
        LocalDateTime e=LocalDateTime.of(2021,12,11,10,0);
        testVO.setCourse_id(1);
        testVO.setStart_time(s);
        testVO.setEnd_time(e);
        testVO.setTname("呆滞测试用测试");
        List<Integer> qList = new ArrayList<>();
        qList.add(1);
        qList.add(2);
        qList.add(3);
        testVO.setQuestionList(qList);

        ResultVO<TestVO> res = testController.createTest(testVO);
        assert (res.getData().getStart_time().toString().equals(s.toString()));
        assert (res.getData().getEnd_time().toString().equals(e.toString()));
        assert (res.getData().getTname().equals("呆滞测试用测试"));
    }

    @Test
    void getAllTest() {
        List<TestVO> testVO=testController.getAllTest(1);
        LocalDateTime s=LocalDateTime.of(2021,6,13,10,0);
        LocalDateTime e=LocalDateTime.of(2020,8,31,10,0);
        assert (testVO.get(0).getId().equals(1));
        assert (testVO.get(0).getCourse_id().equals(1));
        assert (testVO.get(0).getStart_time().toString().equals(s.toString()));
        assert (testVO.get(0).getEnd_time().toString().equals(e.toString()));
        assert (testVO.get(0).getTname().equals("first-test"));
    }

    @Test
    void getAllQuestionByTestId() {
        List<CourseQuestionVO> res = testController.getAllQuestionByTestId(1);
        assert (res.get(0).getDescription().equals(("软工一默认测试的第一题")));
        assert (res.get(1).getDescription().equals(("软工一默认测试的第二题")));
    }

    @Test
    void submitAnswer() {
        //todo 不知道咋测0 0
        ResultVO<TestVO> resultVO=testController.submitAnswer(1,1,"ABC");
        System.out.println(resultVO);

    }
    @Test
    void getTestResult() {
        TestResultVO testResultVO=testController.getTestResult(1,1);
        assert (testResultVO.getUser_score()==50);
        assert (testResultVO.getUser_answer().equals("ABC"));
    }
}