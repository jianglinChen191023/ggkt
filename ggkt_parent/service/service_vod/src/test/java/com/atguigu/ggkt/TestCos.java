package com.atguigu.ggkt;

import com.alibaba.fastjson.JSON;
import com.atguigu.ggkt.vod.config.CosProperties;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 陈江林
 * @date 2022/10/9 13:34
 */
@SpringBootTest
public class TestCos {

    @Autowired
    private CosProperties cosProperties;

    @org.junit.jupiter.api.Test
    public void TestCos() {
        // 指定要上传的文件
        File localFile = new File("/Users/chenjianglin/Desktop/01.png");

        // 1 初始化用户身份信息（secretId, secretKey）。
        // SECRETID 和 SECRETKEY请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = cosProperties.getSecretId();
        String secretKey = cosProperties.getSecretKey();
        // 指定文件将要存放的存储桶
        String bucketName = cosProperties.getBucketName();

        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region(cosProperties.getRegion());
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        // 生成生成文件的目录
        String folderName = new SimpleDateFormat("yyyyMMdd").format(new Date());
        // 使用 UUID 生成文件主体名称
        String fileMainName = UUID.randomUUID().toString().replace("_", "");
        // 使用目录、文件主体名称、文件扩展名称拼接得到对象名称
        String key = folderName + "/" + fileMainName + ".png";

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        // 上传
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println(JSON.toJSONString(putObjectResult));
    }

}
