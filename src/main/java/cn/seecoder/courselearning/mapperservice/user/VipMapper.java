package cn.seecoder.courselearning.mapperservice.user;

import cn.seecoder.courselearning.po.user.Vip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VipMapper {
    int insert(Vip vip);
    List<Vip> selectByStudent_id(@Param("student_id") Integer student_id);
}
