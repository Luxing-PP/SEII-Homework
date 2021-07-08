package cn.seecoder.courselearning.controller.test;
import cn.seecoder.courselearning.vo.test.TestVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class TestControllerTest {

    private TestController testController;

    @BeforeEach
    public void before(@Autowired TestController testController){
        this.testController = testController;
    }

    @Test
    void createTest() {

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
    }

    @Test
    void submitAnswer() {
        int m=0;
        testController.submitAnswer(1,1,"ABC");
    }
}