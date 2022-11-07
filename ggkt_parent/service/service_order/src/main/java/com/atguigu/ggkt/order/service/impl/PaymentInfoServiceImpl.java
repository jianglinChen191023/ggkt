package com.atguigu.ggkt.order.service.impl;

import com.atguigu.ggkt.model.order.PaymentInfo;
import com.atguigu.ggkt.order.mapper.PaymentInfoMapper;
import com.atguigu.ggkt.order.service.PaymentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付信息表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-06
 */
@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements PaymentInfoService {

}
