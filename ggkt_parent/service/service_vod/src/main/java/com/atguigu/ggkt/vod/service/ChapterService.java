package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Chapter;
import com.atguigu.ggkt.vo.vod.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 章节 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
public interface ChapterService extends IService<Chapter> {

    /**
     * 获取章节列表
     *
     * @param courseId 进程id
     * @return {@link List}<{@link ChapterVo}>
     */
    List<ChapterVo> getTreeList(Long courseId);

    /**
     * 根据课程 id 删除章节
     *
     * @param id id
     */
    void removeChapterByCourseId(Long id);

}
