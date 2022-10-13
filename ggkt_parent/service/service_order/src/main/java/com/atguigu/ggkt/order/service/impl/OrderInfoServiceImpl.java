package com.atguigu.ggkt.order.service.impl;

import com.atguigu.ggkt.model.order.OrderDetail;
import com.atguigu.ggkt.model.order.OrderInfo;
import com.atguigu.ggkt.order.mapper.OrderInfoMapper;
import com.atguigu.ggkt.order.service.OrderDetailService;
import com.atguigu.ggkt.order.service.OrderInfoService;
import com.atguigu.ggkt.vo.order.OrderInfoQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    @Autowired
    private OrderDetailService orderDetailService;

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
            if(orderDetail != null) {
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
}
