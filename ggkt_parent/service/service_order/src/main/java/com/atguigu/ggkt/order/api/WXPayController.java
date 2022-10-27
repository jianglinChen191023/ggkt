package com.atguigu.ggkt.order.api;

import com.atguigu.ggkt.order.service.OrderInfoService;
import com.atguigu.ggkt.order.service.WXPayService;
import com.atguigu.ggkt.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class WXPayController {

    @Autowired
    private WXPayService wxPayService;

    @Autowired
    private OrderInfoService orderInfoService;

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

        if ("SUCCESS".equals(resultMap.get("trade_state"))) {
            // 更改订单状态，处理支付结果
            String out_trade_no = resultMap.get("out_trade_no");
            orderInfoService.updateOrderStatus(out_trade_no);
            return Result.ok(null).message("支付成功");
        }

        return Result.ok().message("支付中");
    }
}