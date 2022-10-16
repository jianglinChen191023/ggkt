package com.atguigu.ggkt.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/10/15 23:13
 */
@Data
@Component
@ConfigurationProperties("wx")
public class WxProperties {

    /**
     * 多个模板消息配置信息
     * 键（模板 id）, 值（点击模板消息要访问的网址）
     */
    private Map<String, String> wxMpTemplateMessageObject;

}
