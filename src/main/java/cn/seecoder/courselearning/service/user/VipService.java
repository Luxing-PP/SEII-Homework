package cn.seecoder.courselearning.service.user;

import cn.seecoder.courselearning.vo.user.VipResultVO;

public interface VipService {
    VipResultVO isVip(Integer student_id);
}
