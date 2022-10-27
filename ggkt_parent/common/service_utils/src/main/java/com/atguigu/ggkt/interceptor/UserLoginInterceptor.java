package com.atguigu.ggkt.interceptor;

import com.atguigu.ggkt.util.AuthContextHolder;
import com.atguigu.ggkt.util.JwtHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 陈江林
 * @date 2022/10/21 19:16
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        this.initUserLoginVo(request);
        return true;
    }

    private void initUserLoginVo(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            AuthContextHolder.setUserId(1L);
//            throw new GgktException(208, "未登录");
        } else {
            Long userId = JwtHelper.getUserId(token);
            log.info("当前用户：" + userId);
            if (StringUtils.isEmpty(userId)) {
                AuthContextHolder.setUserId(1L);
//                throw new GgktException(208, "未登录");
            } else {
                AuthContextHolder.setUserId(userId);
            }
        }
    }

}
