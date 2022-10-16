package com.atguigu.ggkt.wechat.service.impl;

import com.atguigu.ggkt.wechat.config.WxProperties;
import com.atguigu.ggkt.wechat.service.MessageService;
import lombok.SneakyThrows;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 公众号消息 服务实现类
 *
 * @author 陈江林
 * @date 2022/10/15 23:06
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxProperties wxProperties;

    //TODO 暂时写成固定值测试，后续完善
    @SneakyThrows
    @Override
    public void pushPayMessage(long orderId) {
        String openid = "oWyia6Mig1f8x9QOcJigHDNHVr-I";

        // 模板id
        String templateId = "2WOzacjuyXuTWESj17xl9TwHBg0gAYlK5aG9TJj0GkM";
        // 点击模板消息要访问的网址
        String url = wxProperties.getWxMpTemplateMessageObject().get(templateId);
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                // 要发送的用户的 openid
                .toUser(openid)
                .templateId(templateId)
                .url(url + orderId)
                .build();
        // 如果是正式版发送消息，，这里需要配置你的信息
        templateMessage.addData(new WxMpTemplateData("first", "亲爱的用户：您有一笔订单支付成功。", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword1", "1314520", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword2", "java基础课程", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword3", "2022-01-11", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword4", "100", "#272727"));
        templateMessage.addData(new WxMpTemplateData("remark", "感谢你购买课程，如有疑问，随时咨询！", "#272727"));
        String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        System.out.println(msg);
    }

}
