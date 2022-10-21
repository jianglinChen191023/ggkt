package com.atguigu.ggkt.vod.service;

import java.util.Map;

/**
 * 腾讯云点播 服务类
 *
 * @author 陈江林
 * @date 2022/10/11 21:33
 */
public interface VodService {

    /**
     * 上传视频
     *
     * @return {@link String}
     */
    String uploadVideo();

    /**
     * 删除视频
     *
     * @param fileId 文件标识
     */
    void removeByFileId(String fileId);

    /**
     * 根据 id 获取对应的视频
     *
     * @param videoId  视频id
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> getPlayAuth(Long videoId);
}
