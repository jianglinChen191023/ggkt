package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
     * @param current        查询页数
     * @param limit          查询数量
     * @param teacherQueryVo 查询条件对象
     * @return {@link Result}
     */
    @ApiOperation(value = "条件查询分页")
    @GetMapping("/findQueryPage/{current}/{limit}")
    public Result<IPage<Teacher>> index(
            @PathVariable Long current,
            @PathVariable Long limit,
            TeacherQueryVo teacherQueryVo) {
        Page<Teacher> pageParam = new Page<>(current, limit);
        if (null == teacherQueryVo) {
            IPage<Teacher> pageModel = teacherService.page(pageParam);
            return Result.ok(pageModel);
        } else {
            // 获取条件
            String name = teacherQueryVo.getName();
            Integer level = teacherQueryVo.getLevel();
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();
            // 进行非空判断, 条件封装
            LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
            if (!StringUtils.isEmpty(name)) {
                wrapper.like(Teacher::getName, name);
            }

            if (!StringUtils.isEmpty(level)) {
                wrapper.eq(Teacher::getLevel, level);
            }

            if (!StringUtils.isEmpty(joinDateBegin)) {
                wrapper.ge(Teacher::getJoinDate, joinDateBegin);
            }

            if (!StringUtils.isEmpty(joinDateEnd)) {
                wrapper.le(Teacher::getJoinDate, joinDateEnd);
            }

            // 调用方法分页查询
            IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);
            return Result.ok(pageModel);
        }
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

