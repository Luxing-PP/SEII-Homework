package cn.seecoder.courselearning.serviceimpl.course;

import cn.seecoder.courselearning.mapperservice.course.CourseQuestionMapper;
import cn.seecoder.courselearning.mapperservice.course.QuestionAnswerMapper;
import cn.seecoder.courselearning.po.course.CourseQuestion;
import cn.seecoder.courselearning.po.course.CourseWare;
import cn.seecoder.courselearning.po.course.QuestionAnswer;
import cn.seecoder.courselearning.service.course.CourseQuestionService;
import cn.seecoder.courselearning.util.Constant;
import cn.seecoder.courselearning.vo.ResultVO;
import cn.seecoder.courselearning.vo.course.CourseQuestionVO;
import cn.seecoder.courselearning.vo.course.CourseWareVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseQuestionServiceImpl implements CourseQuestionService {
    @Resource
    private CourseQuestionMapper courseQuestionMapper;
    @Resource
    private QuestionAnswerMapper questionAnswerMapper;


    @Override
    public ResultVO<CourseQuestionVO> create(CourseQuestionVO courseQuestionVO) {
        // 1.存储答案与解析
        QuestionAnswer questionAnswer = new QuestionAnswer(courseQuestionVO.getCorrect_answer(),courseQuestionVO.getExplain());
        int resA = questionAnswerMapper.insert(questionAnswer);

        // 2.用获取的答案ID构建courseQuestion , 进行存储
        CourseQuestion courseQuestion = new CourseQuestion(courseQuestionVO.getCourse_id(),questionAnswer.getId(),courseQuestionVO.getDescription());
        int resB = courseQuestionMapper.insert(courseQuestion);

        if(resA>0&&resB>0){
            courseQuestionVO.setId(courseQuestion.getId());
            return new ResultVO<CourseQuestionVO>(Constant.REQUEST_SUCCESS,"创建问题成功",courseQuestionVO);
        }
        return new ResultVO<>(Constant.REQUEST_FAIL,"服务器错误");
    }

    @Override
    public List<CourseQuestionVO> getAllQuestionByCourseID(Integer courseId) {
        List<CourseQuestion> tempList = courseQuestionMapper.selectByCourseId(courseId);
        List<CourseQuestionVO> ret = new ArrayList<>();
        for(CourseQuestion courseQuestion: tempList){
            ret.add(new CourseQuestionVO(courseQuestion));
        }
        return ret;
    }

    @Override
    public List<CourseQuestionVO> getQuestionWithAnswerByTestID(Integer testId) {
        List<CourseQuestion> tempList = courseQuestionMapper.selectByTestIdWithAnswer(testId);
        List<CourseQuestionVO> ret = new ArrayList<>();
        for(CourseQuestion courseQuestion: tempList){
            ret.add(new CourseQuestionVO(courseQuestion));
        }
        ret=sort(ret);
        return ret;
    }

    @Override
    public List<CourseQuestionVO> getQuestionNoAnswerByTestID(Integer testId) {
        List<CourseQuestion> tempList = courseQuestionMapper.selectByTestIdNoAnswer(testId);
        List<CourseQuestionVO> ret = new ArrayList<>();
        for(CourseQuestion courseQuestion: tempList){
            ret.add(new CourseQuestionVO(courseQuestion));
        }
        ret=sort(ret);
        return ret;
    }
//按qid排序
    private List<CourseQuestionVO> sort(List<CourseQuestionVO> list){
        for (int i=0;i<list.size()-1;i++){
            for (int j=0;j<list.size()-i-i;j++){
                if (list.get(j).getId()>list.get(j+1).getId()){
                    CourseQuestionVO temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
        return list;
    }
}
