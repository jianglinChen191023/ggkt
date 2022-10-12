package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Chapter;
import com.atguigu.ggkt.model.vod.Video;
import com.atguigu.ggkt.vo.vod.ChapterVo;
import com.atguigu.ggkt.vo.vod.VideoVo;
import com.atguigu.ggkt.vod.mapper.ChapterMapper;
import com.atguigu.ggkt.vod.service.ChapterService;
import com.atguigu.ggkt.vod.service.VideoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 章节 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Autowired
    private VideoService videoService;

    @Override
    public List<ChapterVo> getTreeList(Long courseId) {
        // 定义最终数据
        List<ChapterVo> chapterVoList = new ArrayList<>();

        // 根据 courseId 获取所有章节
        LambdaQueryWrapper<Chapter> wrapperChapter = new LambdaQueryWrapper<>();
        // eq(=)
        wrapperChapter.eq(Chapter::getCourseId, courseId);
        // 查询章节
        List<Chapter> chapterList = baseMapper.selectList(wrapperChapter);

        // 根据 course 获取所有小节
        LambdaQueryWrapper<Video> wrapperVideo = new LambdaQueryWrapper<>();
        // eq(=)
        wrapperVideo.eq(Video::getCourseId, courseId);
        // 查询小节
        List<Video> videoList = videoService.list(wrapperVideo);

        // 封装数据
        // 遍历所有章节
        chapterList.forEach(chapter -> {
            // 创建一个章节视图对象
            ChapterVo chapterVo = new ChapterVo();
            // 复制属性
            BeanUtils.copyProperties(chapter, chapterVo);
            // 存储章节视图对象
            chapterVoList.add(chapterVo);

            // 封装章节 > 小节
            List<VideoVo> videoVoList = new ArrayList<>();
            // 遍历小节
            videoList.forEach(video -> {
                // 判断该小节在那个章节下面
                if (chapter.getId().equals(video.getChapterId())) {
                    // 创建一个小节视图对象
                    VideoVo videoVo = new VideoVo();
                    // 复制属性
                    BeanUtils.copyProperties(video, videoVo);
                    // 存储小节视图对象
                    videoVoList.add(videoVo);
                }
            });

            // 存储小节, 该章节 > 小节集合
            chapterVo.setChildren(videoVoList);
        });

        return chapterVoList;
    }

    @Override
    public void removeChapterById(Long id) {
        // 根据 id 删除章节
        baseMapper.deleteById(id);
        // 根据章节 id 删除对应的小节及视频
        videoService.removeVideoByChapterId(id);
    }

    @Override
    public void removeChapterByCourseId(Long id) {
        // 创建条件对象
        LambdaQueryWrapper<Chapter> wrapper = new LambdaQueryWrapper<>();
        // eq(=)
        wrapper.eq(Chapter::getCourseId, id);
        // 执行删除操作
        baseMapper.delete(wrapper);
    }
}
