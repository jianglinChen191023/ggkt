package com.atguigu.ggkt.client.order;

import com.atguigu.ggkt.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 远程调用接口
 *
 * @author 陈江林
 * @date 2022/11/6 08:51
 */
@FeignClient(value = "service-order")
public interface OrderInfoFeignClient {

    @GetMapping("/api/order/orderInfo/getOrderStatus/{courseId}}")
    Result<String> getOrderStatus(@PathVariable("courseId") Long courseId);

}
