package com.atguigu.ggkt.order.service.impl;

import com.atguigu.ggkt.client.activity.CouponInfoFeignClient;
import com.atguigu.ggkt.client.course.CourseFeignClient;
import com.atguigu.ggkt.client.user.UserInfoFeignClient;
import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.model.activity.CouponInfo;
import com.atguigu.ggkt.model.order.OrderDetail;
import com.atguigu.ggkt.model.order.OrderInfo;
import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.order.mapper.OrderInfoMapper;
import com.atguigu.ggkt.order.service.OrderDetailService;
import com.atguigu.ggkt.order.service.OrderInfoService;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.util.AuthContextHolder;
import com.atguigu.ggkt.util.OrderNoUtils;
import com.atguigu.ggkt.vo.order.OrderFormVo;
import com.atguigu.ggkt.vo.order.OrderInfoQueryVo;
import com.atguigu.ggkt.vo.order.OrderInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@Service
@Slf4j
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private CourseFeignClient courseFeignClient;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    @Autowired
    private CouponInfoFeignClient couponInfoFeignClient;

    @Override
    public Map<String, Object> selectOrderInfoPage(Long page, Long limit, OrderInfoQueryVo orderInfoQueryVo) {
        Map<String, Object> map = new HashMap<>();
        // 创建条件对象
        LambdaQueryWrapper<OrderInfo> wrapper = new LambdaQueryWrapper<>();
        // 创建分页对象
        IPage<OrderInfo> pageParam = new Page<>(page, limit);

        // 判断查询条件
        if (orderInfoQueryVo != null) {
            Long userId = orderInfoQueryVo.getUserId();
            String outTradeNo = orderInfoQueryVo.getOutTradeNo();
            String phone = orderInfoQueryVo.getPhone();
            String createTimeEnd = orderInfoQueryVo.getCreateTimeEnd();
            String createTimeBegin = orderInfoQueryVo.getCreateTimeBegin();
            Integer orderStatus = orderInfoQueryVo.getOrderStatus();

            if (!StringUtils.isEmpty(orderStatus)) {
                wrapper.eq(OrderInfo::getOrderStatus, orderStatus);
            }

            if (!StringUtils.isEmpty(userId)) {
                wrapper.eq(OrderInfo::getUserId, userId);
            }

            if (!StringUtils.isEmpty(outTradeNo)) {
                wrapper.eq(OrderInfo::getOutTradeNo, outTradeNo);
            }

            if (!StringUtils.isEmpty(phone)) {
                wrapper.eq(OrderInfo::getPhone, phone);
            }

            if (!StringUtils.isEmpty(createTimeBegin)) {
                wrapper.ge(OrderInfo::getCreateTime, createTimeBegin);
            }

            if (!StringUtils.isEmpty(createTimeEnd)) {
                wrapper.le(OrderInfo::getCreateTime, createTimeEnd);
            }
        }

        // 分页查询
        IPage<OrderInfo> pages = baseMapper.selectPage(pageParam, wrapper);
        long totalCount = pages.getTotal();
        long pageCount = pages.getPages();
        List<OrderInfo> records = pages.getRecords();
        // 订单里面包含详情内容，封装详情数据，根据订单id查询详情
        records.forEach(orderInfo -> {
            // 订单 id
            Long id = orderInfo.getId();
            // 根据订单 id 查询订单详情
            LambdaQueryWrapper<OrderDetail> lambdaQueryWrapper = new LambdaQueryWrapper();
            lambdaQueryWrapper.eq(OrderDetail::getOrderId, id);
            OrderDetail orderDetail = orderDetailService.getOne(lambdaQueryWrapper);
            if (orderDetail != null) {
                String courseName = orderDetail.getCourseName();
                orderInfo.getParam().put("courseName", courseName);
            }
        });

        // 所有需要数据封装map集合，最终返回
        map.put("total", totalCount);
        map.put("pageCount", pageCount);
        map.put("records", records);
        return map;
    }

    @Override
    public Long submitOrder(OrderFormVo orderFormVo) {
        // 获取生成订单条件值
        if (orderFormVo == null) {
            throw new GgktException(20001, "订单条件不存在");
        }

        Long courseId = orderFormVo.getCourseId();
        Long couponId = orderFormVo.getCouponId();

        // 获取当前用户的 id
        Long userId = AuthContextHolder.getUserId();
        // 判断当前用户, 针对当前课程是否已经生成订单
        // 根据课程 id, 用户 id 查询订单
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getCourseId, courseId);
        queryWrapper.eq(OrderDetail::getUserId, userId);
        OrderDetail orderDetailExist = orderDetailService.getOne(queryWrapper);
        if (orderDetailExist != null) {
            // 如果订单已存在，则直接返回订单 id
            return orderDetailExist.getId();
        }

        // 根据课程 id 查询课程信息
        Course course = courseFeignClient.getById(courseId);
        if (course == null) {
            throw new GgktException(20001, "课程不存在");
        }

        log.info("CS----------------");
        // 根据用户 id 查询用户信息
        Result<UserInfo> result = userInfoFeignClient.getById(userId);
        if (result.getMessage().equals(Result.FAILED)) {
            throw new GgktException(result.getCode(), result.getMessage());
        }

        UserInfo userInfo = result.getData();
        if (userInfo == null) {
            throw new GgktException(20001, "用户不存在");
        }

        // 优惠券金额
        BigDecimal couponReduce = new BigDecimal(0);
        // 是否拥有优惠券
        if (null != couponId) {
            // 根据优惠券 id 查询优惠券信息
            CouponInfo couponInfo = couponInfoFeignClient.getById(couponId);
            couponReduce = couponInfo.getAmount();
        }

        // 封装订单生成需要的数据到对象, 完成添加订单
        // - 封装数据到 OrderInfo 对象中, 添加订单基本信息
        // 创建订单对象
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(userId);
        orderInfo.setNickName(userInfo.getNickName());
        orderInfo.setPhone(userInfo.getPhone());
        orderInfo.setProvince(userInfo.getProvince());
        orderInfo.setOriginAmount(course.getPrice());
        orderInfo.setCouponReduce(couponReduce);
        // 订单总价格 - 优惠券减免
        orderInfo.setFinalAmount(orderInfo.getOriginAmount().subtract(orderInfo.getCouponReduce()));
        // 流水号
        orderInfo.setOutTradeNo(OrderNoUtils.getOrderNo());
        orderInfo.setTradeBody(course.getTitle());
        orderInfo.setOrderStatus("0");
        baseMapper.insert(orderInfo);

        // - 封装数据到 OrderDetail 对象中, 添加订单详情信息表
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderInfo.getId());
        orderDetail.setUserId(userId);
        orderDetail.setCourseId(courseId);
        orderDetail.setCourseName(course.getTitle());
        orderDetail.setCover(course.getCover());
        orderDetail.setOriginAmount(course.getPrice());
        orderDetail.setCouponReduce(new BigDecimal(0));
        orderDetail.setFinalAmount(orderDetail.getOriginAmount().subtract(orderDetail.getCouponReduce()));
        orderDetailService.save(orderDetail);

        // 更新优惠券状态
        if (null != orderFormVo.getCouponUseId()) {
            couponInfoFeignClient.updateCouponInfoUseStatus(orderFormVo.getCouponUseId(), orderInfo.getId());
        }

        // 返回订单 id
        return orderInfo.getId();
    }

    @Override
    public OrderInfoVo getOrderInfoVoById(Long id) {
        // 根据 id 获取订单信息
        OrderInfo orderInfo = baseMapper.selectById(id);
        // 根据 id 获取订单详情
        OrderDetail orderDetail = orderDetailService.getById(id);
        // 创建订单信息视图对象
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        // 将属性复制到视图对象
        BeanUtils.copyProperties(orderInfo, orderInfoVo);
        // 设置属性值
        orderInfoVo.setCourseId(orderDetail.getCourseId());
        orderInfoVo.setCourseName(orderDetail.getCourseName());
        return orderInfoVo;
    }

    @Override
    public void updateOrderStatus(String out_trade_no) {
        // 根据 out_trade_no 查询订单
        LambdaQueryWrapper<OrderInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(OrderInfo::getOutTradeNo, out_trade_no);
        OrderInfo orderInfo = baseMapper.selectOne(wrapper);
        // 更新订单状态 1 已经支付
        orderInfo.setOrderStatus("1");
        baseMapper.updateById(orderInfo);
    }

}
