package com.atguigu.ggkt.activity.service.impl;

import com.atguigu.ggkt.activity.mapper.CouponInfoMapper;
import com.atguigu.ggkt.activity.service.CouponInfoService;
import com.atguigu.ggkt.activity.service.CouponUseService;
import com.atguigu.ggkt.client.user.UserInfoFeignClient;
import com.atguigu.ggkt.model.activity.CouponInfo;
import com.atguigu.ggkt.model.activity.CouponUse;
import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 优惠券信息 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService {
    @Autowired
    private CouponUseService couponUseService;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    @Override
    public IPage<CouponUse> selectCouponUsePage(Page<CouponUse> pageParam1, CouponUseQueryVo couponUseQueryVo) {
        // 创建条件对象
        LambdaQueryWrapper<CouponUse> wrapper = new LambdaQueryWrapper<>();
        IPage<CouponUse> pageParam = new Page<>(1, 2);
        if (couponUseQueryVo != null) {
            // 获取条件
            Long couponId = couponUseQueryVo.getCouponId();
            String couponStatus = couponUseQueryVo.getCouponStatus();
            String getTimeBegin = couponUseQueryVo.getGetTimeBegin();
            String getTimeEnd = couponUseQueryVo.getGetTimeEnd();

            if (!StringUtils.isEmpty(couponId)) {
                wrapper.eq(CouponUse::getCouponId, couponId);
            }

            if (!StringUtils.isEmpty(couponStatus)) {
                wrapper.eq(CouponUse::getCouponStatus, couponStatus);
            }

            if (!StringUtils.isEmpty(getTimeBegin)) {
                wrapper.ge(CouponUse::getGetTime, getTimeBegin);
            }

            if (!StringUtils.isEmpty(getTimeEnd)) {
                wrapper.le(CouponUse::getGetTime, getTimeEnd);
            }
        }

        // 调用方法查询
        IPage<CouponUse> page = couponUseService.page(pageParam, wrapper);
        // 封装用户昵称和手机号
        List<CouponUse> couponUseList = page.getRecords();
        // 遍历
        couponUseList.forEach(couponUse -> {
            // 获取用户 id
            Long userId = couponUse.getUserId();
            if (!StringUtils.isEmpty(userId)) {
                // 调用远程接口获取用户信息
                UserInfo userInfo = userInfoFeignClient.getById(userId);
                if (userInfo != null) {
                    couponUse.getParam().put("nickName", userInfo.getNickName());
                    couponUse.getParam().put("phone", userInfo.getPhone());
                }
            }
        });

        return page;
    }
}
