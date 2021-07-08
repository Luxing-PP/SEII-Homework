package cn.seecoder.courselearning.serviceimpl.test;

import cn.seecoder.courselearning.mapperservice.test.TestMapper;
import cn.seecoder.courselearning.mapperservice.test.TestQuestionMapper;
import cn.seecoder.courselearning.mapperservice.test.TestResultMapper;
import cn.seecoder.courselearning.po.course.CourseWare;
import cn.seecoder.courselearning.po.test.Test;
import cn.seecoder.courselearning.service.Test.TestService;
import cn.seecoder.courselearning.service.course.CourseQuestionService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseQuestionVO;
import cn.seecoder.courselearning.vo.course.CourseWareVO;
import cn.seecoder.courselearning.vo.test.TestVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;
    @Resource
    private TestQuestionMapper testQuestionMapper;

    private CourseQuestionService questionService;

    private TestResultMapper testResultMapper;
    @Autowired
    public void setQuestionService(CourseQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<CourseQuestionVO> getAllQuestionByTestId(Integer testId) {
        //todo 怎么决定返回哪个你们决定叭，实现反正都实现了
        if(true){
            //返回没有答案的（已实现）
            return questionService.getQuestionNoAnswerByTestID(testId);
        }else {
            //返回带答案的
            return questionService.getQuestionWithAnswerByTestID(testId);
        }
    }

    @Override
    public ResultVO<TestVO> createTest(TestVO testVO) {
        Test test = new Test();
        BeanUtils.copyProperties(testVO,test);
        //1. 插入test信息
        int res;
        res = testMapper.insert(test);
        if(res<=0){
            return new ResultVO<>(Constant.REQUEST_FAIL,"服务器内部错误");
        }
        int tid = test.getId();

        //2. 插入test_question信息
        res = testQuestionMapper.insertQuestionList(tid,test.getQuestionList());
        if(res<=0){
            return new ResultVO<>(Constant.REQUEST_FAIL,"服务器内部错误");
        }else {
            return new ResultVO<>(Constant.REQUEST_SUCCESS,"创建测试成功！",new TestVO(test));
        }
    }

    @Override
    public List<TestVO> getAllTest(Integer courseId) {
        Test test=new Test();
        List<Test> tempList = testMapper.selectByCourseId(courseId);
        List<TestVO> ret = new ArrayList<>();
        for(Test test1: tempList){
            ret.add(new TestVO(test1));
        }
        return ret;
    }

    @Override
    public ResultVO<TestVO> submitAnswer(Integer studentID, Integer testID, String answer) {
        int res;
        res=testResultMapper.insertResultList(testID,studentID,answer);
        Test test=new Test();
        if(res<=0){
            return new ResultVO<>(Constant.REQUEST_FAIL,"服务器内部错误");
        }else {
            return new ResultVO<>(Constant.REQUEST_SUCCESS,"提交成功！",new TestVO(test));
        }
    }
}
