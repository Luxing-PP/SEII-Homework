package cn.seecoder.courselearning.vo.user;

import cn.seecoder.courselearning.po.user.Vip;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class VipVO {
    private Integer id;
    private Integer student_id;
    private LocalDateTime start_time;
    private LocalDateTime end_time;

    public VipVO(Vip vip){
        id=vip.getId();
        student_id=vip.getStudent_id();
        start_time=vip.getStart_time();
        end_time=vip.getEnd_time();
    }
}
