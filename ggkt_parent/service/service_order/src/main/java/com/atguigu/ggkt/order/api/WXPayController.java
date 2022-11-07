package com.atguigu.ggkt.order.api;

import com.atguigu.ggkt.enums.PaymentStatus;
import com.atguigu.ggkt.enums.PaymentType;
import com.atguigu.ggkt.model.order.OrderInfo;
import com.atguigu.ggkt.model.order.PaymentInfo;
import com.atguigu.ggkt.order.service.OrderInfoService;
import com.atguigu.ggkt.order.service.PaymentInfoService;
import com.atguigu.ggkt.order.service.WXPayService;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.util.AuthContextHolder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 微信支付接口 控制类
 *
 * @author 陈江林
 * @date 2022/10/21 21:30
 */
@Api(tags = "微信支付接口")
@RestController
@RequestMapping("/api/order/wxPay")
@Slf4j
public class WXPayController {

    @Autowired
    private WXPayService wxPayService;

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private PaymentInfoService paymentInfoService;

    @ApiOperation(value = "下单 小程序支付")
    @GetMapping("/createJsapi/{orderNo}")
    public Result<Map<String, Object>> createJsapi(
            @ApiParam(name = "orderNo", value = "订单No", required = true)
            @PathVariable("orderNo") String orderNo) {
        return Result.ok(wxPayService.createJsapi(orderNo));
    }

    /**
     * 查询支付状态
     *
     * @param orderNo 商户订单号（对应 order_indo 表字段 out_trade_no）
     * @return {@link Result}
     */
    @SneakyThrows
    @ApiOperation(value = "查询支付状态")
    @GetMapping("/queryPayStatus/{orderNo}")
    public Result queryPayStatus(
            @ApiParam(name = "orderNo", value = "订单No（）", required = true)
            @PathVariable("orderNo") String orderNo) {
        // 根据订单号调用微信接口查询支付状态
        Map<String, String> resultMap = wxPayService.queryPayStatus(orderNo);

        if (resultMap == null) {
            return Result.fail(null).message("支付出错");
        }

        log.info("支付信息: " + resultMap);
        if ("SUCCESS".equals(resultMap.get("trade_state"))) {
            // 更改订单状态，处理支付结果
            String out_trade_no = resultMap.get("out_trade_no");
            orderInfoService.updateOrderStatus(out_trade_no);

            // - 添加 payment_info, 记录支付, 微信对账
            // - - 查询订单信息
            OrderInfo orderInfo = orderInfoService.getOne(
                    new LambdaQueryWrapper<OrderInfo>()
                            .eq(OrderInfo::getOutTradeNo, orderNo)
            );
            // - - 添加记录
            PaymentInfo paymentInfo = new PaymentInfo();
            paymentInfo.setOrderId(orderInfo.getId());
            paymentInfo.setOutTradeNo(out_trade_no);
            paymentInfo.setUserId(AuthContextHolder.getUserId());
            paymentInfo.setTotalAmount(orderInfo.getFinalAmount());
            paymentInfo.setTradeBody(orderInfo.getTradeBody());
            paymentInfo.setPaymentType(PaymentType.WEIXIN);
            paymentInfo.setPaymentStatus(PaymentStatus.PAID);
            paymentInfo.setCallbackContent(resultMap.toString());
            String callbackTime = resultMap.get("callbackTime");
            paymentInfo.setCallbackTime(new SimpleDateFormat("yyyyMMddHHmmss").parse(callbackTime));
            Date date = new Date();
            paymentInfo.setCreateTime(date);
            paymentInfo.setUpdateTime(date);
            paymentInfoService.save(paymentInfo);

            return Result.ok(null).message("支付成功");
        }

        return Result.ok().message("支付中");
    }
}