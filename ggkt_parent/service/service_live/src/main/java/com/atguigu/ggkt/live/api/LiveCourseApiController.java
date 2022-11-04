package com.atguigu.ggkt.live.api;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.ggkt.live.service.LiveCourseService;
import com.atguigu.ggkt.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 微信公众号直播观看
 *
 * @author 陈江林
 * @date 2022/11/4 10:31
 */
@Api(tags = "微信公众号直播观看")
@RestController
@RequestMapping("/api/live/liveCourse")
public class LiveCourseApiController {

    @Autowired
    private LiveCourseService liveCourseService;

    @ApiOperation(value = "获取用户 access_token")
    @GetMapping("/getPlayAuth/{id}")
    public Result<JSONObject> getPlayAuth(@PathVariable Long id) {
        return Result.ok(liveCourseService.getPlayAuth(id));
    }

    @ApiOperation("根据ID查询课程")
    @GetMapping("/getInfo/{courseId}")
    public Result<Map<String, Object>> getInfo(
            @ApiParam(value = "课程ID", required = true)
            @PathVariable Long courseId){
        return Result.ok(liveCourseService.getInfoById(courseId));
    }

}