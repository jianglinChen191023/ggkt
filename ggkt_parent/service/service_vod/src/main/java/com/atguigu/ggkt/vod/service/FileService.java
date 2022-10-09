package com.atguigu.ggkt.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 陈江林
 * @date 2022/10/9 14:51
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param file 文件
     * @return {@link String}
     */
    String upload(MultipartFile file);

}
