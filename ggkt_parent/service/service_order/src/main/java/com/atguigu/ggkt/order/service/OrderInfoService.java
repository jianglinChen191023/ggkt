package com.atguigu.ggkt.order.service;

import com.atguigu.ggkt.model.order.OrderInfo;
import com.atguigu.ggkt.vo.order.OrderInfoQueryVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
public interface OrderInfoService extends IService<OrderInfo> {

    /**
     * 订单分页查询
     *
     * @param page             当前页码
     * @param limit            每页记录数
     * @param orderInfoQueryVo 查询条件
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> selectOrderInfoPage(Long page, Long limit, OrderInfoQueryVo orderInfoQueryVo);

}
