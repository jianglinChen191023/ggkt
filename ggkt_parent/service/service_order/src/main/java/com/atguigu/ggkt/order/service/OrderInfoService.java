package com.atguigu.ggkt.order.service;

import com.atguigu.ggkt.model.order.OrderInfo;
import com.atguigu.ggkt.vo.order.OrderFormVo;
import com.atguigu.ggkt.vo.order.OrderInfoQueryVo;
import com.atguigu.ggkt.vo.order.OrderInfoVo;
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

    /**
     * 新增点播课程订单
     *
     * @param orderFormVo
     * @return {@link Long} 返回订单 id
     */
    Long submitOrder(OrderFormVo orderFormVo);

    /**
     * 根据 id 获取订单信息
     *
     * @param id id
     * @return {@link OrderInfoVo}
     */
    OrderInfoVo getOrderInfoVoById(Long id);

    /**
     * 更新订单状态 - 已支付
     *
     * @param out_trade_no 商户订单号
     */
    void updateOrderStatus(String out_trade_no);

    /**
     * 获取订单支付状态
     *
     * @param courseId 课程 id
     * @return {@link String}
     */
    String getOrderStatusByCourseId(Long courseId);

}
