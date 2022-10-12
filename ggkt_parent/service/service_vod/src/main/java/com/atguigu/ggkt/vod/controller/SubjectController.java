package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 课程分类 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-10
 */
@Api(tags = "课程分类")
@RestController
@RequestMapping("/admin/vod/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @ApiOperation("课程分类列表")
    @GetMapping("/getChildSubject/{id}")
    public Result<List<Subject>> getChildSubject(@PathVariable Long id) {
        List<Subject> list = subjectService.selectSubjectList(id);
        return Result.ok(list);
    }

    @ApiOperation("课程分类导出")
    @GetMapping("/exportData")
    public void exportData(HttpServletResponse response) {
        subjectService.exportData(response);
    }

    @ApiOperation("课程分类导入")
    @PostMapping("/importData")
    public Result importData(MultipartFile file) {
        subjectService.importData(file);
        return Result.ok();
    }

}

