package cn.seecoder.courselearning.serviceimpl.user;

import cn.seecoder.courselearning.mapperservice.user.VipMapper;
import cn.seecoder.courselearning.po.user.Vip;
import cn.seecoder.courselearning.service.user.VipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VipServiceImpl implements VipService {
    @Resource
    VipMapper vipMapper;
    @Override
    public Integer isVip(Integer student_id) {
        List<Vip> vips=vipMapper.selectByStudent_id(student_id);
        if (vips.size()>=1) {
            for (Vip vip : vips) {
                if (vip.getEnd_time().isAfter(LocalDateTime.now()))
                    return 1;
            }
            return 0;
        }
        else
        return 0;
    }
}
