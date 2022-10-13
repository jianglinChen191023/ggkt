package com.atguigu.ggkt.user.controller;


import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.user.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/admin/user/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("获取用户")
    @GetMapping("/inner/getById/{id}")
    public Result<UserInfo> getById(@PathVariable Long id) {
        UserInfo userInfo = userInfoService.getById(id);
        return Result.ok(userInfo);
    }

}

