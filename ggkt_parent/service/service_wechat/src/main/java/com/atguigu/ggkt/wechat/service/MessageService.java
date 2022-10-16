package com.atguigu.ggkt.wechat.service;

/**
 * 公众号消息 服务类
 *
 * @author 陈江林
 * @date 2022/10/15 23:05
 */
public interface MessageService {

    /**
     * 发送模板消息
     *
     * @param l l
     */
    void pushPayMessage(long l);

}
