package cn.seecoder.courselearning.vo.user;

import cn.seecoder.courselearning.po.user.VIPResult;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class VipResultVO {
    private Integer student_id;
    private Integer isVip;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    public VipResultVO(VIPResult vipResult){
        student_id=vipResult.getStudent_id();
        isVip=vipResult.getIsVip();
        start_time=vipResult.getStart_time();
        end_time=vipResult.getEnd_time();
    }
}
