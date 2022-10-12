package com.atguigu.ggkt.vod.service;

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

}
