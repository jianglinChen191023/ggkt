package com.atguigu.ggkt.activity.service;

import com.atguigu.ggkt.model.activity.CouponInfo;
import com.atguigu.ggkt.model.activity.CouponUse;
import com.atguigu.ggkt.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 优惠券信息 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
public interface CouponInfoService extends IService<CouponInfo> {

    /**
     * 优惠券分页查询
     *
     * @param pageParam        页面参数
     * @param couponUseQueryVo 优惠券条件对象
     * @return {@link IPage}<{@link CouponUse}>
     */

    IPage<CouponUse> selectCouponUsePage(Page<CouponUse> pageParam, CouponUseQueryVo couponUseQueryVo);
}
