package com.atguigu.ggkt.client.user;

import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
    Result<UserInfo> getById(@PathVariable("id") Long id);

    /**
     * 根据 openid 获取用户信息
     *
     * @param openid openid
     * @return {@link Result}<{@link UserInfo}>
     */
    @GetMapping("/admin/user/userInfo/getUserInfoByOpenId")
    Result<UserInfo> getUserInfoByOpenId(@RequestParam("openid") String openid);

    /**
     * 保存
     *
     * @param userInfo
     * @return {@link Result}
     */
    @PostMapping(value = "/admin/user/userInfo/save", consumes = "application/json")
    Result save(@RequestBody UserInfo userInfo);
}
