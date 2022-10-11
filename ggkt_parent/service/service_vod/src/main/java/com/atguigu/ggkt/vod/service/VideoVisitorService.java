package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.VideoVisitor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 课程统计 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
public interface VideoVisitorService extends IService<VideoVisitor> {

    /**
     * 获取课程统计数据
     *
     * @param courseId  课程 id
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> findCount(Long courseId, String startDate, String endDate);

}
