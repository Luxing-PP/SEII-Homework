package cn.seecoder.courselearning.serviceimpl.test;

import cn.seecoder.courselearning.mapperservice.test.TestMapper;
import cn.seecoder.courselearning.mapperservice.test.TestQuestionMapper;
import cn.seecoder.courselearning.mapperservice.test.TestResultMapper;
import cn.seecoder.courselearning.po.course.CourseWare;
import cn.seecoder.courselearning.po.test.Test;
import cn.seecoder.courselearning.po.test.TestResult;
import cn.seecoder.courselearning.service.Test.TestService;
import cn.seecoder.courselearning.service.course.CourseQuestionService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseQuestionVO;
import cn.seecoder.courselearning.vo.course.CourseWareVO;
import cn.seecoder.courselearning.vo.test.TestResultVO;
import cn.seecoder.courselearning.vo.test.TestVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;
    @Resource
    private TestQuestionMapper testQuestionMapper;
    @Resource
    private TestResultMapper testResultMapper;
    @Resource
    private CourseQuestionService questionService;

    @Autowired
    public void setQuestionService(CourseQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<CourseQuestionVO> getAllQuestionByTestId(Integer testId) {
        //比较当前时间是否已结束测试
        Test test;
        test=testMapper.selectByPrimaryKey(testId);
        LocalDateTime localDateTime=LocalDateTime.now();
        if(localDateTime.isBefore(test.getEnd_time())){
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
        double score=0;
        Test test;
        //1. 获取对应测试问题的答案
        test=testMapper.selectByPrimaryKey(testID);
        List<CourseQuestionVO> QuestionList=questionService.getQuestionWithAnswerByTestID(testID);

        //2. 判断正误
        double eachScore=(double)100/QuestionList.size();
        for (int i=0;i<QuestionList.size();i++){
            if (answer.substring(i, i + 1).equals(QuestionList.get(i).getCorrect_answer()))
                score+=eachScore;
        }
        //3. 保存测试结果
        res=testResultMapper.insertResultList(testID,studentID,answer,score);

        if(res<=0){
            return new ResultVO<>(Constant.REQUEST_FAIL,"服务器内部错误");
        }else {
            return new ResultVO<>(Constant.REQUEST_SUCCESS,"提交成功！",new TestVO(test));
        }

    }

    @Override
    public TestResultVO getTestResult(Integer studentID, Integer testID) {
        Test test=testMapper.selectByPrimaryKey(testID);
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);

        //检查获取时间的合理性，如果还未结束返回空对象
        if(localDateTime.isAfter(test.getEnd_time())){
        List<TestResult> testResult=testResultMapper.selectByTestIdAndStudentId(studentID,testID);
        if(testResult.size() != 0)
        return new TestResultVO(testResult.get(testResult.size()-1));
        return new TestResultVO();
        }
        else {
            return new TestResultVO();
        }
    }
}
