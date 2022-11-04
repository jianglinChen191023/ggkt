package com.atguigu.ggkt.live.controller;

import com.atguigu.ggkt.live.service.LiveCourseAccountService;
import com.atguigu.ggkt.live.service.LiveCourseService;
import com.atguigu.ggkt.model.live.LiveCourse;
import com.atguigu.ggkt.model.live.LiveCourseAccount;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.live.LiveCourseConfigVo;
import com.atguigu.ggkt.vo.live.LiveCourseFormVo;
import com.atguigu.ggkt.vo.live.LiveCourseVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 直播课程表 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
@Api(tags = "直播课程表")
@RestController
@RequestMapping("/admin/live/liveCourse")
public class LiveCourseController {

    @Autowired
    private LiveCourseService liveCourseService;

    @Autowired
    private LiveCourseAccountService liveCourseAccountService;

    @ApiOperation("直播课程列表分页数据")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<LiveCourse>> list(
            @ApiParam(value = "当前页", required = true)
            @PathVariable("page") Long page,
            @ApiParam(value = "每页显示条数", required = true)
            @PathVariable("limit") Long limit
    ) {
        Page<LiveCourse> pageParam = new Page<>(page, limit);
        IPage<LiveCourse> pageModel = liveCourseService.selectPage(pageParam);
        return Result.ok(pageModel);
    }

    @ApiOperation("直播课程添加")
    @PostMapping("/save")
    public Result save(
            @ApiParam(value = "直播课程表单视图对象")
            @RequestBody LiveCourseFormVo liveCourseFormVo
    ) {
        liveCourseService.saveLive(liveCourseFormVo);
        return Result.ok();
    }

    @ApiOperation("直播课程删除")
    @DeleteMapping("/remove/{id}")
    public Result save(
            @ApiParam(value = "直播课程 id")
            @PathVariable Long id
    ) {
        liveCourseService.removeLiveById(id);
        return Result.ok();
    }

    @ApiOperation("直播课程修改")
    @PutMapping("/update")
    public Result update(
            @ApiParam(value = "直播课程表单视图对象")
            @RequestBody LiveCourseFormVo liveCourseFormVo
    ) {
        liveCourseService.updateLiveById(liveCourseFormVo);
        return Result.ok();
    }

    @ApiOperation("根据 id 查询直播课程信息")
    @GetMapping("/get/{id}")
    public Result<LiveCourse> get(
            @ApiParam(value = "直播课程 id")
            @PathVariable Long id
    ) {
        return Result.ok(liveCourseService.getById(id));
    }

    @ApiOperation("根据 id 查询直播课程信息和描述信息")
    @GetMapping("/getInfo/{id}")
    public Result<LiveCourseFormVo> getInfo(
            @ApiParam(value = "直播课程 id")
            @PathVariable Long id
    ) {
        return Result.ok(liveCourseService.getLiveCourseVo(id));
    }

    @ApiOperation("查询直播课程账号信息")
    @GetMapping("/getLiveCourseAccount/{id}")
    public Result<LiveCourseAccount> getLiveCourseAccount(
            @ApiParam(value = "直播课程 id")
            @PathVariable Long id
    ) {
        return Result.ok(liveCourseAccountService.getLiveCourseAccountByLiveCourseId(id));
    }

    @ApiOperation("获取直播配置信息")
    @GetMapping("/getCourseConfig/{id}")
    public Result<LiveCourseConfigVo> getCourseConfig(
            @ApiParam(value = "直播课程 id")
            @PathVariable Long id
    ) {
        return Result.ok(liveCourseService.getCourseConfigByLiveCourseId(id));
    }

    @ApiOperation("修改直播配置信息")
    @PutMapping("/updateConfig/{id}")
    public Result<LiveCourseConfigVo> updateConfig(
            @ApiParam(value = "直播课程配置视图对象")
            @PathVariable LiveCourseConfigVo liveCourseConfigVo
    ) {
        liveCourseService.updateConfig(liveCourseConfigVo);
        return Result.ok();
    }

    @ApiOperation("获取最近的直播")
    @GetMapping("/findLatelyList")
    public Result<List<LiveCourseVo>> getLatelyList() {
        return Result.ok(liveCourseService.getLatelyList());
    }

}

