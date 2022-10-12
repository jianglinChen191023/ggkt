package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Video;
import com.atguigu.ggkt.vod.mapper.VideoMapper;
import com.atguigu.ggkt.vod.service.VideoService;
import com.atguigu.ggkt.vod.service.VodService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Autowired
    private VodService vodService;

    @Override
    public void removeVideoByCourseId(Long id) {
        // 创建条件对象
        LambdaQueryWrapper<Video> wrapper = new LambdaQueryWrapper<>();
        // eq(=)
        wrapper.eq(Video::getCourseId, id);

        // 根据课程 id 查询所有小节
        List<Video> videos = baseMapper.selectList(wrapper);
        // 遍历所有小节 - 删除视频
        videos.forEach(video -> {
            // 获取视频 id
            String videoSourceId = video.getVideoSourceId();
            // 如果视频 id 不为空
            if (!StringUtils.isEmpty(video)) {
                // 删除腾讯云视频
                vodService.removeByFileId(videoSourceId);
            }
        });

        // 根据课程 id 删除所有小节
        baseMapper.delete(wrapper);
    }

    @Override
    public void removeVideoById(Long id) {
        // id 查询小节信息
        Video video = baseMapper.selectById(id);
        // 获取 video 中视频 id
        String videoSourceId = video.getVideoSourceId();
        // 判断视频 id 是否为空
        if (!StringUtils.isEmpty(videoSourceId)) {
            // 视频 id 不为空, 调用方法删除腾讯云中的视频
            vodService.removeByFileId(videoSourceId);
        }

        // 根据 id 删除小节
        baseMapper.deleteById(id);
    }

    @Override
    public void removeVideoByChapterId(Long id) {
        // 创建条件对象
        LambdaQueryWrapper<Video> wrapper = new LambdaQueryWrapper<>();
        // 章节 id
        wrapper.eq(Video::getChapterId, id);
        // 查询该章节所有小节
        List<Video> videos = baseMapper.selectList(wrapper);
        // 循环删除视频
        videos.forEach(video -> {
            // 获取 video 中视频 id
            String videoSourceId = video.getVideoSourceId();
            // 判断视频 id 是否为空
            if (!StringUtils.isEmpty(videoSourceId)) {
                // 视频 id 不为空, 调用方法删除腾讯云中的视频
                vodService.removeByFileId(videoSourceId);
            }
        });

        // 根据章节 id 删除所有小节
        baseMapper.delete(wrapper);
    }

}
