package com.atguigu.ggkt.live.service;

import com.atguigu.ggkt.model.live.LiveCourseAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 直播课程账号表（受保护信息） 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
public interface LiveCourseAccountService extends IService<LiveCourseAccount> {

    /**
     * 查询直播课程账号信息
     *
     * @param id 直播课程 id
     * @return {@link Object}
     */
    LiveCourseAccount getLiveCourseAccountByLiveCourseId(Long id);

}
