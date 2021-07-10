package cn.seecoder.courselearning.serviceimpl.user;

import cn.seecoder.courselearning.po.user.VIPResult;
import cn.seecoder.courselearning.mapperservice.user.VipMapper;
import cn.seecoder.courselearning.po.user.Vip;
import cn.seecoder.courselearning.service.user.VipService;
import cn.seecoder.courselearning.vo.user.VipResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VipServiceImpl implements VipService {
    @Resource
    VipMapper vipMapper;
    @Override
    public VipResultVO isVip(Integer student_id) {
        List<Vip> vips=vipMapper.selectByStudent_id(student_id);
        VIPResult vipResult=new VIPResult();
        vipResult.setIsVip(0);
        if (vips.size()>=1) {
            for (Vip vip : vips) {
                if (vip.getEnd_time().isAfter(LocalDateTime.now()))
                {
                    vipResult.setIsVip(1);
                    vipResult.setStart_time(vip.getStart_time());
                    vipResult.setEnd_time(vip.getEnd_time());
                    vipResult.setStudent_id(vip.getStudent_id());
                    break;
                }
            }
        }
        return new VipResultVO(vipResult);
    }
}
