package com.atguigu.ggkt.live.config;

import com.atguigu.ggkt.live.mtcloud.MTCloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 欢拓云配置类
 *
 * @author 陈江林
 * @date 2022/11/1 10:56
 */
@Configuration
public class MTCloudConfig {

    @Autowired
    private MTCloudProperties mtCloudProperties;

    @Bean
    public MTCloud mtCloudClient() {
        return new MTCloud(mtCloudProperties.getOpenId(),
                mtCloudProperties.getOpenToken());
    }

}
