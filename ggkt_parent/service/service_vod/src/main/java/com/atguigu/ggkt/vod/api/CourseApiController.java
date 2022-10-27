package com.atguigu.ggkt.vod.api;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.CourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 微信公众号接口 课程信息
 *
 * @author 陈江林
 * @date 2022/10/15 14:00
 */
@Slf4j
@Api(tags = "微信公众号接口 课程信息")
@RestController
@RequestMapping("/api/vod/course")
public class CourseApiController {

    @Autowired
    private CourseService courseService;

    @ApiOperation("根据ID查询课程")
    @GetMapping("/inner/getById/{courseId}")
    public Course getById(
            @ApiParam(value = "课程ID", required = true)
            @PathVariable Long courseId){
        return courseService.getById(courseId);
    }

    @ApiOperation("根据关键字查询课程")
    @GetMapping("/inner/findByKeyword/{keyword}")
    public List<Course> findByKeyword(
            @ApiParam(value = "关键字", required = true)
            @PathVariable String keyword) {
        log.info("根据关键字查询课程");
        QueryWrapper<Course> queryWrapper = new QueryWrapper();
        queryWrapper.like("title", keyword);
        List<Course> list = courseService.list(queryWrapper);
        return list;
    }

    @ApiOperation("根据课程分类 id 查询课程列表（分页）")
    @GetMapping("/{subjectId}/{page}/{limit}")
    public Result<Map<String, Object>> findPageCourse(
            @ApiParam(value = "课程一级分类 id", required = true)
            @PathVariable Long subjectId,
            @ApiParam(value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(value = "每页记录数", required = true)
            @PathVariable Long limit
    ) {
        Map<String, Object> map = courseService.findPage(subjectId, page, limit);
        return Result.ok(map);
    }

    @ApiOperation("根据课程 id 查询课程详情")
    @GetMapping("/getInfo/{courseId}")
    public Result<Map<String, Object>> getInfo(
            @ApiParam(value = "课程 id", required = true)
            @PathVariable Long courseId
    ) {
        Map<String, Object> map = courseService.getInfoById(courseId);
        return Result.ok(map);
    }

}
