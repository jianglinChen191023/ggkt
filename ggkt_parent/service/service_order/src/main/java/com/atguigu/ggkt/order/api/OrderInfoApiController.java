package com.atguigu.ggkt.order.api;

import com.atguigu.ggkt.order.service.OrderInfoService;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.order.OrderFormVo;
import com.atguigu.ggkt.vo.order.OrderInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 付费观看点播课程 控制类
 *
 * @author 陈江林
 * @date 2022/10/21 17:52
 */
@Api(tags = "付费观看点播课程")
@RestController
@RequestMapping("api/order/orderInfo")
public class OrderInfoApiController {

    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation(value = " 获取订单信息")
    @GetMapping("/getInfo/{id}")
    public Result<OrderInfoVo> getInfo(@PathVariable("id") Long id) {
        OrderInfoVo orderInfoVo = orderInfoService.getOrderInfoVoById(id);
        return Result.ok(orderInfoVo);
    }

    @ApiOperation("新增点播课程订单")
    @PostMapping("/submitOrder")
    public Result<Long> submitOrder(@RequestBody OrderFormVo orderFormVo, HttpServletRequest request) {
        return Result.ok(orderInfoService.submitOrder(orderFormVo));
    }

    @ApiOperation(value = "获取订单支付状态")
    @GetMapping("/getOrderStatus/{courseId}}")
    public Result<String> getOrderStatus(@PathVariable("courseId") Long courseId) {
        return Result.ok(orderInfoService.getOrderStatusByCourseId(courseId));
    }

}
