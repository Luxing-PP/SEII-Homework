package cn.seecoder.courselearning.controller.test;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestControllerTest {

    private TestController testController;

    @BeforeEach
    public void before(@Autowired TestController testController){
        this.testController = testController;
    }

    @Test
    void createTest() {
        int m=0;
        testController.submitAnswer(1,1,"ABC");
    }

    @Test
    void getAllTest() {
    }

    @Test
    void getAllQuestionByTestId() {
    }

    @Test
    void submitAnswer() {
    }
}