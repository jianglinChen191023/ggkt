package com.atguigu.ggkt.wechat.api;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.util.http.URIUtil;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 示例
 * 获取 openid 控制类
 *
 * @author 陈江林
 * @date 2022/10/25 18:38
 */
@Controller
@RequestMapping("/api/wechat/openid")
public class GetOpenIdController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize() {
        // 正式号的授权的回调域名
        // 使用尚硅谷的接口获取 openid
        String userInfoUrl = "http://glkt.atguigu.cn/api/user/openid/userInfo";

        // 构造 oauth2 授权的 url 连接
        String redirectURL = wxMpService.getOAuth2Service()
                .buildAuthorizationUrl(userInfoUrl,
                        WxConsts.OAuth2Scope.SNSAPI_USERINFO,
                        URIUtil.encodeURIComponent(""));
        // 跳转回调 redirect_uri，应当使用 https 链接来确保授权 code 的安全性
        // 重定向到用户授权界面, 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
        return "redirect:" + redirectURL;
    }

    /**
     * 获取 openid
     *
     * @param code
     * @return {@link String}
     * @throws Exception
     */
    @GetMapping("/userInfo")
    @ResponseBody
    public String userInfo(@RequestParam("code") String code) throws Exception {
        // 通过 code 换取网页授权 access_token
        WxOAuth2AccessToken accessToken = wxMpService.getOAuth2Service().getAccessToken(code);
        // 拉取用户信息(需 scope 为 snsapi_userinfo)
        WxOAuth2UserInfo user = wxMpService.getOAuth2Service().getUserInfo(accessToken, null);
        return user.getOpenid();
    }

}
