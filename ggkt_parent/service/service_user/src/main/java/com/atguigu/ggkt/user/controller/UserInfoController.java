package com.atguigu.ggkt.user.controller;


import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.user.service.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result<UserInfo> getById(@PathVariable("id") Long id) {
        UserInfo userInfo = userInfoService.getById(id);
        return Result.ok(userInfo);
    }

    @ApiOperation("根据 openid 获取用户信息")
    @GetMapping("/getUserInfoByOpenId")
    public Result<UserInfo> getUserInfoByOpenId(@RequestParam("openid") String openid) {
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper();
        wrapper.eq(UserInfo::getOpenId, openid);
        UserInfo userInfo = userInfoService.getOne(wrapper);
        return Result.ok(userInfo);
    }

    @ApiOperation("保存用户信息")
    @PostMapping(value = "/save", consumes = "application/json")
    public Result save(@RequestBody UserInfo userInfo) {
        userInfoService.save(userInfo);
        return Result.ok();
    }

}

