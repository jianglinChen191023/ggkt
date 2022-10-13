package com.atguigu.ggkt.order.controller;


import com.atguigu.ggkt.order.service.OrderInfoService;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.order.OrderInfoQueryVo;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@RestController
@RequestMapping("/admin/order/orderInfo")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping("/{page}/{limit}")
    public Result<Map<String, Object>> listOrder(
            @ApiParam(name = "page", value = "当前页码")
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数")
            @PathVariable Long limit,

            @ApiParam(name = "orderInfoQueryVo", value = "查询条件对象")
            OrderInfoQueryVo orderInfoQueryVo
    ) {
        Map<String, Object> map = orderInfoService.selectOrderInfoPage(page, limit, orderInfoQueryVo);
        return Result.ok(map);
    }

}

