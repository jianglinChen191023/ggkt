package com.atguigu.ggkt.wechat.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.ggkt.client.user.UserInfoFeignClient;
import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.util.JwtHelper;
import com.atguigu.ggkt.wechat.config.WxProperties;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.http.URIUtil;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 公众号网页授权
 *
 * @author 陈江林
 * @date 2022/10/17 16:20
 */
@Slf4j
@Controller
@RequestMapping("/api/wechat/redirect")
public class WechatController {

    @Autowired
    private WxMpService wxService;

    @Autowired
    private WxProperties wxProperties;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    /**
     * 第一步 用户同意授权获取 code
     *
     * @return {@link String}
     */
    @RequestMapping("/authorize")
    public String authorize(@RequestParam String returnUrl) {
        log.info("returnUrl: " + returnUrl);
        // 构造 oauth2 授权的 url 连接
        String url = wxService.getOAuth2Service()
                .buildAuthorizationUrl(wxProperties.getUserInfoUrl(),
                        WxConsts.OAuth2Scope.SNSAPI_USERINFO,
                        URIUtil.encodeURIComponent(returnUrl.replace("guiguketan", "#")));
        // 跳转回调 redirect_uri，应当使用 https 链接来确保授权 code 的安全性
        // 重定向到用户授权界面, 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
        log.info("redirect_uri: " + url);
        return "redirect:" + url;
    }

    /**
     * 拉取用户信息
     *
     * @param code
     * @param state
     * @return {@link String}
     */
    @RequestMapping("/userInfo")
    public String userInfo(@RequestParam String code, @RequestParam String state) {
        log.info("state: " + state);
        try {
            // 第二步：通过 code 换取网页授权 access_token
            WxOAuth2AccessToken accessToken = wxService.getOAuth2Service().getAccessToken(code);
            /// 第三步：刷新access_token（如果需要）
            // 第四步：拉取用户信息(需 scope 为 snsapi_userinfo)
            WxOAuth2UserInfo user = wxService.getOAuth2Service().getUserInfo(accessToken, null);
            log.info(JSON.toJSONString(user));

            // 1. 保存用户信息
            // 1.1 检查是否已保存
            // 获取用户 openid
            String openid = user.getOpenid();
            // 根据 openid 获取用户信息

            Result<UserInfo> result = userInfoFeignClient.getUserInfoByOpenId(openid);
            if (result.getMessage().equals(Result.FAILED)) {
                return null;
            }

            UserInfo userInfo = result.getData();
            if (userInfo == null) {
                // 创建用户信息对象
                userInfo = new UserInfo();
                userInfo.setOpenId(openid);
                userInfo.setNickName(user.getNickname());
                userInfo.setAvatar(user.getHeadImgUrl());
                userInfo.setSex(user.getSex());
                userInfo.setProvince(user.getProvince());
                // 保存操作
                userInfoFeignClient.save(userInfo);
            }

            // 生成 token, 按照一定规则生成字符串, 可以包含用户信息
            String token = JwtHelper.createToken(userInfo.getId(), userInfo.getNickName());
            log.info("token: " + token);
            if (!token.contains("?")) {
                return "redirect:" + state + "?token=" + token;
            } else {
                return "redirect:" + state + "&token=" + token;
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        return "null";
    }

}
