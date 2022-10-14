package com.atguigu.ggkt.wechat.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * 微信配置类
 *
 * @author 陈江林
 * @date 2022/10/14 15:27
 */
@Configuration
public class WxMpConfiguration {

    @Autowired
    private WxMpProperties wxMpProperties;

    @Bean
    public WxMpService wxMpService() {
        WxMpService service = new WxMpServiceImpl();
        WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
        configStorage.setAppId(wxMpProperties.getAppId());
        configStorage.setSecret(wxMpProperties.getSecret());
//        configStorage.setToken(wxMpProperties.getToken());
//        configStorage.setAesKey(wxMpProperties.getAesKey());
        service.setWxMpConfigStorage(configStorage);

        return service;
    }

    public WxMpService wxMpService2() {
        return new Function<WxMpDefaultConfigImpl, WxMpService>() {
            @Override
            public WxMpService apply(WxMpDefaultConfigImpl wxMpDefaultConfig) {
                WxMpService service = new WxMpServiceImpl();
                wxMpDefaultConfig.setAppId(wxMpProperties.getAppId());
                wxMpDefaultConfig.setSecret(wxMpProperties.getSecret());
                service.setWxMpConfigStorage(wxMpDefaultConfig);
                return service;
            }
        }.apply(new WxMpDefaultConfigImpl());
    }

    public WxMpService wxMpService3() {
        return ((Function<WxMpDefaultConfigImpl, WxMpService>) wxMpDefaultConfig -> {
            WxMpService service = new WxMpServiceImpl();
            wxMpDefaultConfig.setAppId(wxMpProperties.getAppId());
            wxMpDefaultConfig.setSecret(wxMpProperties.getSecret());
            service.setWxMpConfigStorage(wxMpDefaultConfig);
            return service;
        }).apply(new WxMpDefaultConfigImpl());
    }

    public WxMpService wxMpService4() {
        WxMpDefaultConfigImpl wxMpDefaultConfig = new WxMpDefaultConfigImpl();
        WxMpService service = new WxMpServiceImpl();
        wxMpDefaultConfig.setAppId(wxMpProperties.getAppId());
        wxMpDefaultConfig.setSecret(wxMpProperties.getSecret());
        service.setWxMpConfigStorage(wxMpDefaultConfig);
        return service;
    }

}
