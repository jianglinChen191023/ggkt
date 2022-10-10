package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程分类 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-10
 */
public interface SubjectService extends IService<Subject> {

    /**
     * 查询课程分类列表
     *
     * @param id id
     * @return {@link List}<{@link Subject}>
     */
    List<Subject> selectSubjectList(Long id);
}
