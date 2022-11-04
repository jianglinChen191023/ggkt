package com.atguigu.ggkt.live.service;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.ggkt.model.live.LiveCourse;
import com.atguigu.ggkt.vo.live.LiveCourseConfigVo;
import com.atguigu.ggkt.vo.live.LiveCourseFormVo;
import com.atguigu.ggkt.vo.live.LiveCourseVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 直播课程表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
public interface LiveCourseService extends IService<LiveCourse> {

    /**
     * 直播课程列表分页数据
     *
     * @param pageParam
     * @return
     */
    IPage<LiveCourse> selectPage(Page<LiveCourse> pageParam);

    /**
     * 直播课程添加
     *
     * @param liveCourseFormVo 直播课程表单视图对象
     */
    void saveLive(LiveCourseFormVo liveCourseFormVo);

    /**
     * 直播课程删除
     *
     * @param id id
     */
    void removeLiveById(Long id);

    /**
     * 根据 id 查询直播课程信息和描述信息
     *
     * @param id 课程 id
     * @return {@link LiveCourseFormVo}
     */
    LiveCourseFormVo getLiveCourseVo(Long id);

    /**
     * 直播课程修改
     *
     * @param liveCourseFormVo 直播课程表单视图对象
     */
    void updateLiveById(LiveCourseFormVo liveCourseFormVo);

    /**
     * 根据直播课程 id 获取直播配置信息
     *
     * @param id 直播课程 id
     * @return {@link LiveCourseConfigVo} 直播课程配置视图对象
     */
    LiveCourseConfigVo getCourseConfigByLiveCourseId(Long id);

    /**
     * 修改直播配置信息
     *
     * @param liveCourseConfigVo 直播课程配置视图对象
     */
    void updateConfig(LiveCourseConfigVo liveCourseConfigVo);

    /**
     * 获取最近的直播
     *
     * @return {@link List}<{@link LiveCourseVo}>
     */
    List<LiveCourseVo> getLatelyList();

    /**
     * 获取用户 access_token
     *
     * @param id id
     * @return {@link JSONObject}
     */
    JSONObject getPlayAuth(Long id);

    /**
     * 根据ID查询课程
     *
     * @param courseId 课程ID
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> getInfoById(Long courseId);
}
