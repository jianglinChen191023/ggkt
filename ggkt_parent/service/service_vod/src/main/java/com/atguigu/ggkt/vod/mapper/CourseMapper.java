package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.vo.vod.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 根据 id 查询发布课程信息
     *
     * @param id id
     * @return {@link CoursePublishVo}
     */
    CoursePublishVo selectCoursePublishVoById(Long id);

}
