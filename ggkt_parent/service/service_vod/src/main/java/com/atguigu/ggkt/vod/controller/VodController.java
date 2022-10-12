package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.util.Signature;
import com.atguigu.ggkt.vod.config.CosProperties;
import com.atguigu.ggkt.vod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * 腾讯云点播 控制类
 *
 * @author 陈江林
 * @date 2022/10/11 21:25
 */
@Api(tags = "腾讯云点播")
@RestController
@RequestMapping("/admin/vod")
public class VodController {

    @Autowired
    private VodService vodService;

    @Autowired
    private CosProperties cosProperties;

    @ApiOperation("客户端上传视频签名")
    @GetMapping("/getSign")
    public Result getSign() {
        Signature sign = new Signature();
        // 设置 App 的云 API 密钥
        sign.setSecretId(cosProperties.getSecretId());
        sign.setSecretKey(cosProperties.getSecretKey());
        sign.setCurrentTime(System.currentTimeMillis() / 1000);
        sign.setRandom(new Random().nextInt(java.lang.Integer.MAX_VALUE));
        // 签名有效期：2天
        sign.setSignValidDuration(3600 * 24 * 2);

        try {
            String signature = sign.getUploadSignature();
            return Result.ok(signature);
        } catch (Exception e) {
            throw new GgktException(20001, "获取签名失败");
        }
    }

    @ApiOperation("上传视频")
    @PostMapping("/upload")
    public Result<String> upload() {
        String fileId = vodService.uploadVideo();
        return Result.ok(fileId);
    }

    @ApiOperation("删除视频")
    @DeleteMapping("/remove/{fileId}")
    public Result remove(@PathVariable String fileId) {
        vodService.removeByFileId(fileId);
        return Result.ok();
    }

}
