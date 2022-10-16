package com.atguigu.ggkt.wechat.handler;

import com.atguigu.ggkt.client.course.CourseFeignClient;
import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.wechat.builder.TextBuilder;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Autowired
    private CourseFeignClient courseFeignClient;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //TODO 组装回复消息
        // String content = JsonUtils.toJson(wxMessage);

        // 默认回复文本信息
        String content = "请重新输入关键字，没有匹配到相关视频课程";

        // 搜索课程信息
        WxMpXmlOutMessage courseWxMpXmlOutMessage = course(wxMessage);
        // 如果有则回复图文信息
        if (courseWxMpXmlOutMessage != null) {
            return courseWxMpXmlOutMessage;
        }

        return new TextBuilder().build(content, wxMessage, weixinService);
    }

    /**
     * 搜索课程信息, 回复用户
     * 图文消息个数；当用户发送文本、图片、语音、视频、图文、地理位置这六种消息时，开发者只能回复1条图文消息；
     * 其余场景最多可回复8条图文消息
     *
     * @param wxMessage
     * @return {@link WxMpXmlOutMessage}
     */
    public WxMpXmlOutMessage course(WxMpXmlMessage wxMessage) {
        List<Course> courseList = courseFeignClient.findByKeyword(wxMessage.getContent());
        if (CollectionUtils.isEmpty(courseList)) {
            return null;
        }

        List<Item> itemList = new ArrayList<>();
        courseList.forEach(course -> {
            // 获取课程属性
            String title = course.getTitle();
            String cover = course.getCover();
            String url = "http://glkt.atguigu.cn/#/liveInfo/" + course.getId();
            // 创建对象
            Item item = new Item();
            item.setTitle(title);
            item.setDescription(title);
            item.setPicUrl(cover);
            item.setUrl(url);

            itemList.add(item);
        });

        return WxMpXmlOutMessage.NEWS().articles(itemList)
                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                .build();
    }
}
