package cn.seecoder.courselearning.controller.coupon;

import cn.seecoder.courselearning.dto.coupon.CouponDTO;
import cn.seecoder.courselearning.dto.coupon.DeliverCouponDTO;
import cn.seecoder.courselearning.po.coupon.Coupon;
import cn.seecoder.courselearning.service.coupon.CouponService;
import cn.seecoder.courselearning.vo.coupon.CouponVO;
import cn.seecoder.courselearning.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Resource
    CouponService couponService;

    //根据userID和courseID获取可用的优惠券，返回可用优惠券列表，这是一个查操作

    // use Coupon 在User里

    // 创建优惠券
    @PostMapping("/create")
    ResultVO<CouponVO> createCoupon(@RequestBody CouponDTO universalCouponDTO) {
        return couponService.createCoupon(universalCouponDTO);
    }

    // 查看所有的优惠券
    @GetMapping("/getAll")
    ResultVO<List<CouponVO>> getAll() {
        return couponService.getAllAvailableCoupons();
    }

    // 获取订单可用的优惠券
    @GetMapping("/getForOrder")
    ResultVO<List<CouponVO>> getForOrder(@RequestParam Integer orderId) {
        return couponService.getAllAvailableCouponsForOrder(orderId);
    }

    // 发放优惠券
    @PostMapping("/deliver")
    ResultVO<Boolean> deliver(@RequestBody DeliverCouponDTO deliverCouponDTO) {
        return couponService.deliverCoupon(deliverCouponDTO);
    }
}
