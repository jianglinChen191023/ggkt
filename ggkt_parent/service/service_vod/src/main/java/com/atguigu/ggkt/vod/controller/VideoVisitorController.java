package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.VideoVisitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 课程统计 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Api(tags = "课程统计")
@RestController
@RequestMapping("/admin/vod/videoVisitor")
public class VideoVisitorController {

    @Autowired
    private VideoVisitorService videoVisitorService;

    @ApiOperation("获取课程统计数据")
    @GetMapping("/findCount/{courseId}/{startDate}/{endDate}")
    public Result<Map<String, Object>> findCount(@PathVariable Long courseId,
                                                 @PathVariable String startDate,
                                                 @PathVariable String endDate) {
        Map<String, Object> map = videoVisitorService.findCount(courseId, startDate, endDate);
        return Result.ok(map);
    }

}

