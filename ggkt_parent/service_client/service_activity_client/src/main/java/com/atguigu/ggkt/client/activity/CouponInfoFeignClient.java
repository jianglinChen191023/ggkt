package com.atguigu.ggkt.client.activity;

import com.atguigu.ggkt.model.activity.CouponInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 陈江林
 * @date 2022/10/21 18:47
 */
@FeignClient(value = "service-activity")
public interface CouponInfoFeignClient {

    /**
     * 获取优惠券
     *
     * @param couponId 优惠券 id
     * @return {@link CouponInfo}
     */
    @GetMapping(value = "/api/activity/couponInfo/inner/getById/{couponId}")
    CouponInfo getById(@PathVariable("couponId") Long couponId);

    /**
     * 更新优惠券使用状态
     *
     * @param couponUseId 优惠券使用 id
     * @param orderId     订单 id
     * @return {@link Boolean}
     */
    @GetMapping(value = "/api/activity/couponInfo/inner/updateCouponInfoUseStatus/{couponUseId}/{orderId}")
    Boolean updateCouponInfoUseStatus(@PathVariable("couponUseId") Long couponUseId, @PathVariable("orderId") Long orderId);

}
