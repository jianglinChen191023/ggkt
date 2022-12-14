package com.atguigu.ggkt.vod.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 腾讯云对象存储 COS 的属性配置文件
 *
 * @author 陈江林
 * @date 2022/10/9 14:36
 */
@Data
@Component
@ConfigurationProperties(prefix = "tencent.cos")
public class CosProperties {

    /**
     * 所属地域
     */
    private String region;

    /**
     * 秘钥标识
     */
    private String secretId;

    /**
     * 秘钥
     */
    private String secretKey;

    /**
     * Bucket 名称
     */
    private String bucketName;

    /**
     * Bucket 域名
     */
    private String bucketDomain;

}
