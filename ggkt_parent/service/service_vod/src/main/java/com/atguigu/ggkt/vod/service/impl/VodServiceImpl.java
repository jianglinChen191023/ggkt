package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.vod.config.CosProperties;
import com.atguigu.ggkt.vod.service.VodService;
import com.qcloud.vod.VodUploadClient;
import com.qcloud.vod.model.VodUploadRequest;
import com.qcloud.vod.model.VodUploadResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.vod.v20180717.VodClient;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaRequest;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 腾讯云点播 服务实现类
 *
 * @author 陈江林
 * @date 2022/10/11 21:34
 */
@Service
public class VodServiceImpl implements VodService {

    @Autowired
    private CosProperties cosProperties;

    @Override
    public String uploadVideo() {
        VodUploadClient client = new VodUploadClient(cosProperties.getSecretId(), cosProperties.getSecretKey());
        VodUploadRequest request = new VodUploadRequest();
        request.setMediaFilePath("/opt/video/test.mov");
        request.setProcedure("LongVideoPreset");
        try {
            VodUploadResponse response = client.upload("ap-guangzhou", request);
            // 返回上传后的视频 id
            return response.getFileId();
        } catch (Exception e) {
            throw new GgktException(20001, "视频上传失败");
        }
    }

    @Override
    public void removeByFileId(String fileId) {
        try {
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential(cosProperties.getSecretId(), cosProperties.getSecretKey());
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("vod.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            VodClient client = new VodClient(cred, "", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            DeleteMediaRequest req = new DeleteMediaRequest();
            req.setFileId(fileId);
            // 返回的resp是一个DeleteMediaResponse的实例，与请求对象对应
            DeleteMediaResponse resp = client.DeleteMedia(req);
            // 输出json格式的字符串回包
            System.out.println(DeleteMediaResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            throw new GgktException(20001, "删除上传失败");
        }
    }

}
