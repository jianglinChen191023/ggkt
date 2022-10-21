package com.atguigu.ggkt.vod.api;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 腾讯视频点播 控制类
 *
 * @author 陈江林
 * @date 2022/10/21 16:29
 */
@Api(tags = "腾讯视频点播")
@RestController
@RequestMapping("/api/vod")
public class VodApiController {

    @Autowired
    private VodService vodService;

    @GetMapping("/getPlayAuth/{videoId}")
    public Result<Map<String, Object>> getPlayAuth(
            @ApiParam(value = "小节id", required = true)
            @PathVariable Long videoId) {
        return Result.ok(vodService.getPlayAuth(videoId));
    }

}
