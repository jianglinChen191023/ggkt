package com.atguigu.ggkt.wechat.api;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.util.AuthContextHolder;
import com.atguigu.ggkt.util.Base64Util;
import com.atguigu.ggkt.vo.wechat.WxJsapiSignatureVo;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信 jsapi
 *
 *
 * @author 陈江林
 * @date 2022/11/4 23:52
 */
@RestController
@RequestMapping("/api/wechat/share")
@Slf4j
public class ShareController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/getSignature")
    public Result getSignature(@RequestParam("url") String url) throws WxErrorException {
        // 微信分享要对当前url加密处理，由于我们的url路由都是带“#”符号，服务器端接收不到，因此通过“guiguketan”单词代替了“#”
        String currentUrl = url.replace("guiguketan", "#");
        // 创建调用 jsapi 时所需要的签名
        WxJsapiSignature jsapiSignature = wxMpService.createJsapiSignature(currentUrl);

        WxJsapiSignatureVo wxJsapiSignatureVo = new WxJsapiSignatureVo();
        BeanUtils.copyProperties(jsapiSignature, wxJsapiSignatureVo);
        wxJsapiSignatureVo.setUserEedId(Base64Util.base64Encode(AuthContextHolder.getUserId() + ""));
        return Result.ok(wxJsapiSignatureVo);
    }

}
