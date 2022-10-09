package com.atguigu.ggkt.util;

import com.atguigu.ggkt.result.Result;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 硅谷课堂工具类
 *
 * @author 陈江林
 * @date 2022/10/9 15:30
 */
public class GgktUtil {

    /**
     * 专门负责上传文件到 COS 服务器的工具方法
     *
     * @param bucketName
     * @param region
     * @param bucketDomain
     * @param secretId
     * @param secretKey
     * @param inputStream  要上传文件的输入流
     * @param originalName 要上传文件的原始文件名
     * @return {@link Result}<{@link String}>
     */
    public static Result<String> uploadFilterCos(String bucketName,
                                                 String region,
                                                 String bucketDomain,
                                                 String secretId,
                                                 String secretKey,
                                                 InputStream inputStream,
                                                 String originalName) {
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        Region region1 = new Region(region);
        ClientConfig clientConfig = new ClientConfig(region1);
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 生成生成文件的目录
        String folderName = new SimpleDateFormat("yyyyMMdd").format(new Date());
        // 使用 UUID 生成文件主体名称
        String fileMainName = UUID.randomUUID().toString().replace("_", "");
        // 从原始文件名中获取文件扩展名
        String extensionName = originalName.substring(originalName.lastIndexOf("."));
        // 使用目录、文件主体名称、文件扩展名称拼接得到对象名称
        String key = folderName + "/" + fileMainName + extensionName;

        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, objectMetadata);
            // 设置存储类型（如有需要，不需要请忽略此行代码）, 默认是标准(Standard), 低频(standard_ia)
            putObjectRequest.setStorageClass(StorageClass.Standard_IA);
            // 上传
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            String cosFileAccessPath = bucketDomain + "/" + key;
            // 返回上传文件的访问路径
            return Result.ok(cosFileAccessPath);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

}
