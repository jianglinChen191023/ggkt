package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.util.GgktUtil;
import com.atguigu.ggkt.vod.config.CosProperties;
import com.atguigu.ggkt.vod.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 陈江林
 * @date 2022/10/9 14:51
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private CosProperties cosProperties;

    @Override
    public String upload(MultipartFile file) {
        try {
            // 上传文件
            Result<String> result = GgktUtil.uploadFilterCos(cosProperties.getBucketName(),
                    cosProperties.getRegion(),
                    cosProperties.getBucketDomain(),
                    cosProperties.getSecretId(),
                    cosProperties.getSecretKey(),
                    file.getInputStream(),
                    file.getOriginalFilename());
            // 如果上传成功则返回文件路径
            if (result.getMessage().equals(Result.SUCCESS)) {
                return result.getData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
