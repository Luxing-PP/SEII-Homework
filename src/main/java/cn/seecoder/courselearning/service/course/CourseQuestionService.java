package cn.seecoder.courselearning.service.course;

import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseQuestionVO;

import java.util.List;

public interface CourseQuestionService {
    //创建问题
    ResultVO<CourseQuestionVO> create(CourseQuestionVO courseQuestionVO);

    //获取跟当前课程相关的所有题目
    List<CourseQuestionVO> getAllQuestionByCourseID(Integer courseId);

    //获取某测试带答案的所有题目
    List<CourseQuestionVO> getQuestionWithAnswerByTestID(Integer testId);

    //获取某测试无答案的所有题目
    List<CourseQuestionVO> getQuestionNoAnswerByTestID(Integer testId);
}
