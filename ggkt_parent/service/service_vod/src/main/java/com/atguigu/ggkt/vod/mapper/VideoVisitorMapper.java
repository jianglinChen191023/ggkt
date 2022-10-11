package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.VideoVisitor;
import com.atguigu.ggkt.vo.vod.VideoVisitorCountVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程统计 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {

    /**
     * 获取课程统计数据
     *
     * @param courseId  课程 id
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return {@link List}<{@link VideoVisitorCountVo}>
     */
    List<VideoVisitorCountVo> findCount(
            @Param("courseId") Long courseId,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);

}
