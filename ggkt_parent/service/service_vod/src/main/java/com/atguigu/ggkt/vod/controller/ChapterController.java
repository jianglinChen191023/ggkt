package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.model.vod.Chapter;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.ChapterVo;
import com.atguigu.ggkt.vod.service.ChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 章节 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Api(tags = "章节")
@RestController
@RequestMapping("/admin/vod/chapter")
@CrossOrigin
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @ApiOperation("根据课程 id 获取大纲列表（章节和小节列表）")
    @GetMapping("/getNestedTreeList/{courseId}")
    public Result<List<ChapterVo>> get(@PathVariable Long courseId) {
        List<ChapterVo> list = chapterService.getTreeList(courseId);
        return Result.ok(list);
    }

    @ApiOperation("添加章节")
    @PostMapping("/save")
    public Result add(@RequestBody Chapter chapter) {
        chapterService.save(chapter);
        return Result.ok();
    }

    @ApiOperation("根据课程 id 获取章节")
    @GetMapping("/get/{id}")
    public Result<Chapter> getById(@PathVariable Long id) {
        Chapter chapter = chapterService.getById(id);
        return Result.ok(chapter);
    }

    @ApiOperation("修改章节信息")
    @PutMapping("/update")
    public Result update(@RequestBody Chapter chapter) {
        chapterService.updateById(chapter);
        return Result.ok();
    }

    @ApiOperation("删除章节")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id) {
        chapterService.removeChapterById(id);
        return Result.ok();
    }

}

