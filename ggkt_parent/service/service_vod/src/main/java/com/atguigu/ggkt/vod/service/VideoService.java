package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
public interface VideoService extends IService<Video> {

    /**
     * 根据课程 id 删除小节
     *
     * @param id 课程 id
     */
    void removeVideoByCourseId(Long id);

    /**
     * 通过 id 删除小节、视频
     *
     * @param id 小节 id
     */
    void removeVideoById(Long id);

    /**
     * 根据章节 id 删除对应的小节及视频
     *
     * @param id id
     */
    void removeVideoByChapterId(Long id);
}
