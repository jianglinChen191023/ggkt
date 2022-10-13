package com.atguigu.ggkt.client.user;

import com.atguigu.ggkt.model.user.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 远程调用接口
 *
 * @author 陈江林
 * @date 2022/10/13 14:37
 */
@FeignClient(value = "service-user")
public interface UserInfoFeignClient {

    /**
     * 根据 id 查询用户数据
     *
     * @param id id
     * @return {@link UserInfo}
     */
    @GetMapping("/admin/user/userInfo/inner/getById/{id}")
    UserInfo getById(@PathVariable Long id);

}
