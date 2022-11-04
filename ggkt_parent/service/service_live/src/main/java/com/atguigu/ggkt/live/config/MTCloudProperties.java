package com.atguigu.ggkt.live.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 欢拓云 属性配置类
 *
 * @author 陈江林
 * @date 2022/11/1 10:51
 */
@Data
@Component
@ConfigurationProperties("mtcloud")
public class MTCloudProperties {

    /**
     * 合作方ID： 合作方在欢拓平台的唯一ID
     */
    private String openId;

    /**
     * 合作方秘钥： 合作方ID对应的参数加密秘钥
     */
    private String openToken;

}
