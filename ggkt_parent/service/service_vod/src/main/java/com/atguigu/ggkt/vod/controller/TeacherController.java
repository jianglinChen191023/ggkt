package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-01
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有讲师
     *
     * @return {@link List}<{@link Teacher}>
     */
    @ApiOperation("查询所有讲师")
    @GetMapping("/findAll")
    public Result<List<Teacher>> findAllTeacher() {
        // 模拟异常
        try {
            // int i = 10/0;
        } catch (Exception e) {
            // 抛出异常
            throw new GgktException(201, "执行自定义异常处理");
        }

        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功");
    }

    /**
     * 通过 id 逻辑删除讲师
     *
     * @param id id
     * @return boolean
     */
    @ApiOperation("通过 id 逻辑删除讲师")
    @DeleteMapping("/remove/{id}")
    public Result removeTeacherById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable("id") Long id) {
        boolean b = teacherService.removeById(id);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 条件查询分页列表
     *
     * @param page           查询页数
     * @param limit          查询数量
     * @param teacherQueryVo 查询条件对象
     * @return {@link Result}
     */
    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<Teacher>> index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherVo", value = "查询对象", required = false)
            @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
        //创建page对象，传递当前页和每页记录数
        Page<Teacher> pageParam = new Page<>(page, limit);
        //获取条件值
        //讲师名称
        String name = teacherQueryVo.getName();
        //讲师级别
        Integer level = teacherQueryVo.getLevel();
        //开始时间
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();
        //结束时间
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();
        //封装条件
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(joinDateBegin)) {
            wrapper.ge("join_date", joinDateBegin);
        }
        if (!StringUtils.isEmpty(joinDateEnd)) {
            wrapper.le("join_date", joinDateEnd);
        }
        //调用方法得到分页查询结果
        IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);
        return Result.ok(pageModel);
    }

    /**
     * 新增讲师
     *
     * @param teacher 讲师对象
     * @return {@link Result}
     */
    @ApiOperation(value = "新增讲师")
    @PostMapping("/save")
    public Result saveTeacher(@RequestBody Teacher teacher) {
        // 执行保存操作
        boolean isSuccess = teacherService.save(teacher);
        // 判断是否执行成功
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 修改讲师信息
     *
     * @param teacher 讲师对象
     * @return {@link Result}
     */
    @ApiOperation(value = "修改讲师信息")
    @PutMapping("/update")
    public Result updateTeacher(@RequestBody Teacher teacher) {
        // 执行修改操作
        boolean isSuccess = teacherService.updateById(teacher);
        // 判断是否执行成功
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 根据 id 查询讲师
     *
     * @param id id
     * @return {@link Result}<{@link Teacher}>
     */
    @ApiOperation(value = "根据 id 查询讲师")
    @GetMapping("/get/{id}")
    public Result<Teacher> get(@PathVariable Long id) {
        // 根据 id 获取讲师对象
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }

    /**
     * 批量删除讲师
     *
     * @param idList id 列表
     * @return {@link Result}
     */
    @ApiOperation(value = "批量删除讲师")
    @DeleteMapping("/batch/remove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        // 执行删除操作
        boolean isSuccess = teacherService.removeByIds(idList);
        // 判断是否执行成功
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}

