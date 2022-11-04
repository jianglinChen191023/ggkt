package com.atguigu.ggkt.util;

import com.atguigu.ggkt.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring Mvc 配置类
 *
 * @author 陈江林
 * @date 2022/10/21 19:12
 */
@Configuration
// @EnableWebMvc
public class LoginWebMvcConfigurerImpl implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加自定义拦截器, 设置拦截路径
        registry.addInterceptor(new UserLoginInterceptor())
                .addPathPatterns("/api/**");
    }

}
