package com.atguigu.ggkt.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 陈江林
 * @date 2022/10/13 14:16
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.atguigu")
public class ServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }

}
