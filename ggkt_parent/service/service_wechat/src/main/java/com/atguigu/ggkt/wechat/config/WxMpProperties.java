package com.atguigu.ggkt.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信公众号属性配置类
 *
 * @author 陈江林
 * @date 2022/10/14 15:27
 */
@Data
@Component
@ConfigurationProperties("wx.mp")
public class WxMpProperties {

    /**
     * 公众号的 appid
     */
    private String appId;

    /**
     * 公众号的 appsecret
     */
    private String secret;

}
