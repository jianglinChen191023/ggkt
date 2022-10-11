package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.CourseFormVo;
import com.atguigu.ggkt.vo.vod.CoursePublishVo;
import com.atguigu.ggkt.vo.vod.CourseQueryVo;
import com.atguigu.ggkt.vod.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Api(tags = "点播课程")
@RestController
@RequestMapping("/admin/vod/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation("点播课程列表")
    @GetMapping("/{page}/{limit}")
    public Result<Map<String, Object>> courseList(@PathVariable Long page,
                                                  @PathVariable Long limit,
                                                  CourseQueryVo courseQueryVo) {
        Map<String, Object> map = courseService.findPageCourse(page, limit, courseQueryVo);
        return Result.ok(map);
    }

    @ApiOperation("添加课程基本信息")
    @PostMapping("/save")
    public Result<Long> save(@RequestBody CourseFormVo courseFormVo) {
        Long courseId = courseService.saveCourseInfo(courseFormVo);
        return Result.ok(courseId);
    }

    @ApiOperation("根据 id 获取课程信息")
    @GetMapping("/get/{id}")
    public Result<CourseFormVo> get(@PathVariable Long id) {
        CourseFormVo courseFormVo = courseService.getCourseInfoById(id);
        return Result.ok(courseFormVo);
    }

    @ApiOperation("修改课程信息")
    @PutMapping("/update")
    public Result get(@RequestBody CourseFormVo courseFormVo) {
        courseService.updateCourseId(courseFormVo);
        return Result.ok();
    }

    @ApiOperation("根据 id 查询发布课程信息")
    @GetMapping("/getCoursePublishVo/{id}")
    public Result<CoursePublishVo> getCoursePublishVo(@PathVariable Long id) {
        CoursePublishVo coursePublishVo = courseService.getCoursePublishVo(id);
        return Result.ok(coursePublishVo);
    }

    @ApiOperation("课程最终发布")
    @GetMapping("/publishCourse/{id}")
    public Result publishCourse(@PathVariable Long id) {
        courseService.publishCourse(id);
        return Result.ok();
    }

}

