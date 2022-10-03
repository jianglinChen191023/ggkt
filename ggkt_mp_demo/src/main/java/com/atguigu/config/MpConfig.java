package com.atguigu.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatisPlus 配置文件
 *
 * @author 陈江林
 * @date 2022/10/4 04:20
 */
@Configuration
public class MpConfig {

    /**
     * 分页插件
     * `@Bean`: 将对象注册到 IOC 容器中
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 返回分页对象
        return new PaginationInterceptor();
    }

}