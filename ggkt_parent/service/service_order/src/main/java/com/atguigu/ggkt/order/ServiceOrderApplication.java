package com.atguigu.ggkt.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 陈江林
 * @date 2022/10/13 07:53
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.atguigu")
@EnableFeignClients(basePackages = "com.atguigu")
public class ServiceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }

}
