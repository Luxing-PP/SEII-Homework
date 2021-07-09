package cn.seecoder.courselearning.controller.course;

import cn.seecoder.courselearning.controller.test.TestController;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseQuestionVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseQuestionControllerTest {

    private CourseQuestionController courseQuestionController;

    @BeforeEach
    public void before(@Autowired CourseQuestionController courseQuestionController){
        this.courseQuestionController = courseQuestionController;
    }

    @Test
    void createQuestion() {
        CourseQuestionVO item = new CourseQuestionVO();
        item.setCorrect_answer("A");
        item.setCourse_id(1);
        item.setExplain("啊啊阿巴巴解析");
        item.setDescription("呆滞测试用问题");
        item.setOptionA("测试用选项A");
        item.setOptionB("测试用选项B");
        item.setOptionC("测试用选项C");
        item.setOptionD("测试用选项D");

        ResultVO<CourseQuestionVO> res = courseQuestionController.createQuestion(item);

        assertNotEquals(null,res.getData().getId());
        assert(res.getData().getDescription().equals("呆滞测试用问题"));
    }

    @Test
    void getAllQuestionByCourseID() {
        List<CourseQuestionVO> res = courseQuestionController.getAllQuestionByCourseID(1);
        boolean isRight = false;

        for(CourseQuestionVO cvo : res){
            if(cvo.getDescription().equals("呆滞测试用问题")) {
                isRight=true;
            }
        }

        assert (isRight==true);
    }
}