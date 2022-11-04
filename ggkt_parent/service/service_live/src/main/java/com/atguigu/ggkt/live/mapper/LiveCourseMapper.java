package com.atguigu.ggkt.live.mapper;

        import com.atguigu.ggkt.model.live.LiveCourse;
        import com.atguigu.ggkt.vo.live.LiveCourseVo;
        import com.baomidou.mybatisplus.core.mapper.BaseMapper;

        import java.util.List;

/**
 * <p>
 * 直播课程表 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
public interface LiveCourseMapper extends BaseMapper<LiveCourse> {

    /**
     * 获取最近的直播
     *
     * @return {@link List}<{@link LiveCourseVo}>
     */
    List<LiveCourseVo> getLatelyList();

}
