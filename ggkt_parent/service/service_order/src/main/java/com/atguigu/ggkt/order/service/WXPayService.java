package com.atguigu.ggkt.order.service;

import java.util.Map;

/**
 * 微信支付接口 接口类
 *
 * @author 陈江林
 * @date 2022/10/21 21:31
 */
public interface WXPayService {

    /**
     * 微信支付
     *
     * @param orderNo 订单号
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> createJsapi(String orderNo);

    /**
     * 根据订单号调用微信接口查询支付状态
     *
     * @param orderNo 微信订单号
     * @return {@link Map}<{@link String}, {@link String}>
     */
    Map<String, String> queryPayStatus(String orderNo);
}
