package com.atguigu.ggkt.order.service.impl;

import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.order.service.WXPayService;
import com.atguigu.ggkt.util.HttpClientUtils;
import com.github.wxpay.sdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信支付接口 接口实现类
 *
 * @author 陈江林
 * @date 2022/10/21 21:31
 */
@Slf4j
@Service
public class WXPayServiceImpl implements WXPayService {

    @Override
    public Map<String, Object> createJsapi(String orderNo) {
        // 封装微信支付需要参数, 使用 map 集合
        Map<String, String> paramMap = new HashMap<>();
        // 设置参数

        // 正式服务号 id
        paramMap.put("appid", "wxf913bfa3a2c7eeeb");
        // 服务号的商户号
        paramMap.put("mch_id", "1481962542");
        // 使用微信提供的工具类生成 32 位随机字符串
        paramMap.put("nonce_str", WXPayUtil.generateNonceStr());
        // 微信弹框
        paramMap.put("body", "test");
        paramMap.put("out_trade_no", orderNo);
        // 支付金额
        // 测试支付 0.01
        paramMap.put("total_fee", "1");
        // 当前支付客户端的 ip 地址
        paramMap.put("spbill_create_ip", "127.0.0.1");
        // 支付之后的跳转
        paramMap.put("notify_url", "http://glkt.atguigu.cn/api/order/wxPay/notify");

        paramMap.put("trade_type", "JSAPI");
        // 设置参数值当前微信用户 openid
        // - 根据订单号获取用户 id, 根据用户 id 获取 openid
        // - 因为当前使用测试号, 测试号不支持支付功能, 为了使用正式服务号测试, 直接设置 oQTXC56lAy3xMOCkKCImHtHoLL
        // paramMap.put("openid", "o1R-t5trto9c5sdYt6l1ncGmY5Y");
        // UserInfo userInfo = userInfoFeignClient.getById(paymentInfo.getUserId());
        // paramMap.put("openid", "oepf36SawvvS8Rdqva-Cy4flFFg");
        paramMap.put("openid", "oQTXC56lAy3xMOCkKCImHtHoLL");

        // 通过 httpclient 调用微信支付接口
        // HTTPClient 来根据URL访问第三方接口并且传递参数
        // - url: 微信固定路径
        HttpClientUtils client = new HttpClientUtils("https://api.mch.weixin.qq.com/pay/unifiedorder");

        try {
            // 设置请求参数
            // - 参数
            // key: 商户 key
            String paramXml = WXPayUtil.generateSignature(paramMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9");
            client.setXmlParam(paramXml);
            client.setHttps(true);
            // 请求
            client.post();

            // 微信支付接口返回数据
            String xml = client.getContent();
            log.info("XML: " + xml);
            // xml -> map
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);

            // 进行封装
            if (null != resultMap.get("result_code") && !"SUCCESS".equals(resultMap.get("result_code"))) {
                throw new GgktException(20001, "支付失败");
            }

            //4、再次封装参数
            Map<String, String> parameterMap = new HashMap<>();
            String prepayId = String.valueOf(resultMap.get("prepay_id"));
            String packages = "prepay_id=" + prepayId;
            parameterMap.put("appId", "wxf913bfa3a2c7eeeb");
            parameterMap.put("nonceStr", resultMap.get("nonce_str"));
            parameterMap.put("package", packages);
            parameterMap.put("signType", "MD5");
            parameterMap.put("timeStamp", String.valueOf(System.currentTimeMillis()));
            String sign = WXPayUtil.generateSignature(parameterMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9");

            //返回结果
            Map<String, Object> result = new HashMap<>();
            result.put("appId", "wxf913bfa3a2c7eeeb");
            result.put("timeStamp", parameterMap.get("timeStamp"));
            result.put("nonceStr", parameterMap.get("nonceStr"));
            result.put("signType", "MD5");
            result.put("paySign", sign);
            result.put("package", packages);
            System.out.println(result);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Map<String, String> queryPayStatus(String orderNo) {
        try {
            // 1、封装参数
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("appid", "wxf913bfa3a2c7eeeb");
            paramMap.put("mch_id", "1481962542");
            paramMap.put("out_trade_no", orderNo);
            paramMap.put("nonce_str", WXPayUtil.generateNonceStr());

            // 2、设置请求
            HttpClientUtils client = new HttpClientUtils("https://api.mch.weixin.qq.com/pay/orderquery");
            client.setXmlParam(WXPayUtil.generateSignedXml(paramMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9"));
            client.setHttps(true);
            client.post();
            // 3、返回第三方的数据
            String xml = client.getContent();
            // 6、转成Map
            // 7、返回
            return WXPayUtil.xmlToMap(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
