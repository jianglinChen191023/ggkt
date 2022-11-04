package com.atguigu.ggkt.live.service;

import com.atguigu.ggkt.model.live.LiveCourseConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 直播课程配置表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
public interface LiveCourseConfigService extends IService<LiveCourseConfig> {

    /**
     * 根据直播课程 id 查询配置信息
     *
     * @param id 直播课程 id
     * @return {@link LiveCourseConfig}
     */
    LiveCourseConfig getCourseConfigByLiveCourseId(Long id);
}
