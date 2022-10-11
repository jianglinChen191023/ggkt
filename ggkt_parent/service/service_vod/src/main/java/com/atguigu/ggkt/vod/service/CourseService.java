package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.vo.vod.CourseFormVo;
import com.atguigu.ggkt.vo.vod.CourseQueryVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
public interface CourseService extends IService<Course> {

    /**
     * 查询点播课程列表
     *
     * @param page          页数
     * @param limit         每页查询数
     * @param courseQueryVo 查询条件
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> findPageCourse(Long page, Long limit, CourseQueryVo courseQueryVo);

    /**
     * 保存课程信息
     *
     * @param courseFormVo
     * @return {@link Long}
     */
    Long saveCourseInfo(CourseFormVo courseFormVo);

    /**
     * 通过 id 获取课程信息
     *
     * @param id id
     * @return {@link CourseFormVo}
     */
    CourseFormVo getCourseInfoById(Long id);

    /**
     * 更新课程信息
     *
     * @param courseFormVo
     */
    void updateCourseId(CourseFormVo courseFormVo);
}
