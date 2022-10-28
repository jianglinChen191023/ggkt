package com.atguigu.ggkt.interceptor;

import com.atguigu.ggkt.util.AuthContextHolder;
import com.atguigu.ggkt.util.JwtHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 陈江林
 * @date 2022/10/21 19:16
 */
@Slf4j
public class UserLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        log.info("当前用户token：" + token);
        if (StringUtils.isEmpty(token)) {
            AuthContextHolder.setUserId(1L);
            // throw new GgktException(208, "未登录");
        } else {
            Long userId = JwtHelper.getUserId(token);
            log.info("当前用户：" + userId);
            if (StringUtils.isEmpty(userId)) {
                AuthContextHolder.setUserId(1L);
                // throw new GgktException(208, "未登录");
            } else {
                AuthContextHolder.setUserId(userId);
            }
        }

        return true;
    }

}
