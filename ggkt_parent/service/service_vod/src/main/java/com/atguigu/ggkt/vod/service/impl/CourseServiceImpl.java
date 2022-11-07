package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.client.order.OrderInfoFeignClient;
import com.atguigu.ggkt.constant.GgktConstant;
import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.model.vod.CourseDescription;
import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.*;
import com.atguigu.ggkt.vod.mapper.CourseMapper;
import com.atguigu.ggkt.vod.service.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private OrderInfoFeignClient orderInfoFeignClient;

    @Override
    public Map<String, Object> findPageCourse(Long page, Long limit, CourseQueryVo courseQueryVo) {
        Map<String, Object> map = new HashMap<>();
        Page<Course> pageParam = new Page<>(page, limit);
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        if (courseQueryVo != null) {
            // 获取条件值
            String title = courseQueryVo.getTitle();
            Long subjectId = courseQueryVo.getSubjectId();
            Long subjectParentId = courseQueryVo.getSubjectParentId();
            Long teacherId = courseQueryVo.getTeacherId();

            // 判断条件
            if (!StringUtils.isEmpty(title)) {
                wrapper.like(Course::getTitle, title);
            }

            if (!StringUtils.isEmpty(subjectId)) {
                wrapper.eq(Course::getSubjectId, subjectId);
            }

            if (!StringUtils.isEmpty(subjectParentId)) {
                wrapper.eq(Course::getSubjectParentId, subjectParentId);
            }

            if (!StringUtils.isEmpty(teacherId)) {
                wrapper.eq(Course::getTeacherId, teacherId);
            }
        }

        // 查询数据
        Page<Course> pages = baseMapper.selectPage(pageParam, wrapper);
        Long totalCount = pages.getTotal();
        Long totalPage = pages.getPages();
        List<Course> list = pages.getRecords();

        // 查询数据里面有几个 id
        // 讲师 id, 课程分类 id（一层 和 而层）
        // 获取这些 id 对应的名称, 进行封装, 最终显示
        list.forEach(course -> {
            // 封装数据
            // 根据讲师 id 获取讲师名称
            Teacher teacher = teacherService.getById(course.getTeacherId());
            if (teacher != null) {
                String name = teacher.getName();
                course.getParam().put("teacherName", name);
            }

            // 根据课程分类 id 获取课程分类名称
            Subject subjectOne = subjectService.getById(course.getSubjectParentId());
            if (subjectOne != null) {
                course.getParam().put("subjectParentTitle", subjectOne.getTitle());
            }

            Subject subjectTwo = subjectService.getById(course.getSubjectId());
            if (subjectTwo != null) {
                course.getParam().put("subjectTitle", subjectTwo.getTitle());
            }
        });

        map.put("total", totalCount);
        map.put("page", totalPage);
        map.put("records", list);
        return map;
    }

    @Override
    public Long saveCourseInfo(CourseFormVo courseFormVo) {
        // 添加课程基本信息, 操作 course 表
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.insert(course);
        // 添加课程描述信息, 操作 course_description
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseFormVo.getDescription());
        // 设置课程的 id
        courseDescription.setId(course.getId());
        courseDescriptionService.save(courseDescription);

        return course.getId();
    }

    @Override
    public CourseFormVo getCourseInfoById(Long id) {
        // 查询课程信息
        Course course = baseMapper.selectById(id);

        // 查询课程描述信息
        CourseDescription courseDescription = courseDescriptionService.getById(id);

        // 封装数据
        CourseFormVo courseFormVo = new CourseFormVo();
        if (course != null) {
            BeanUtils.copyProperties(course, courseFormVo);
        }

        if (courseDescription != null) {
            courseFormVo.setDescription(courseDescription.getDescription());
        }

        return courseFormVo;
    }

    @Override
    public void updateCourseId(CourseFormVo courseFormVo) {
        // 修改课程基本信息
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.updateById(course);

        // 修改课程的描述信息
        CourseDescription description = new CourseDescription();
        description.setDescription(courseFormVo.getDescription());
        courseDescriptionService.updateById(description);
    }

    @Override
    public CoursePublishVo getCoursePublishVo(Long id) {
        return baseMapper.selectCoursePublishVoById(id);
    }

    @Override
    public void publishCourse(Long id) {
        Course course = baseMapper.selectById(id);
        // 已经发布
        course.setStatus(1);
        course.setPublishTime(new Date());
        baseMapper.updateById(course);
    }

    @Override
    public void removeCourseById(Long id) {
        // 根据课程 id 删除小节
        videoService.removeVideoByCourseId(id);
        // 根据课程 id 删除章节
        chapterService.removeChapterByCourseId(id);
        // 根据课程 id 删除课程描述
        courseDescriptionService.removeById(id);
        // 根据课程 id 删除课程
        baseMapper.deleteById(id);
    }

    @Override
    public Map<String, Object> findPage(Long subjectId, Long page, Long limit) {
        // 创建分页对象
        IPage<Course> coursePage = new Page<>(page, limit);
        // 创建条件对象
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Course::getSubjectParentId, subjectId);
        // 分页查询
        IPage<Course> courseIPage = baseMapper.selectPage(coursePage, wrapper);


        // 每页数据集合
        List<Course> records = courseIPage.getRecords();
        records.stream().forEach(course -> {
            // 封装其他数据
            // 根据讲师 id 获取讲师对象
            Teacher teacher = teacherService.getById(course.getTeacherId());
            if (teacher != null) {
                course.getParam().put("teacherName", teacher.getName());
            }

            // 一级分类标题
            Subject subject = subjectService.getById(course.getSubjectParentId());
            if (subject != null) {
                course.getParam().put("subjectParentTitle", subject.getTitle());
            }

            // 二级分类标题
            Subject subjectTwo = subjectService.getById(course.getSubjectId());
            if (subjectTwo != null) {
                course.getParam().put("subjectTitle", subjectTwo.getTitle());
            }
        });

        // 总记录数
        long totalCount = courseIPage.getTotal();
        // 总页数
        long totalPage = courseIPage.getPages();
        // 当前页
        long currentPage = courseIPage.getCurrent();
        // 每页记录数
        long size = courseIPage.getSize();

        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("totalPage", totalPage);
        map.put("records", records);
        return map;
    }

    @Override
    public Map<String, Object> getInfoById(Long courseId) {
        Course course = baseMapper.selectById(courseId);
        if (course == null) {
            return null;
        }

        course.setViewCount(course.getViewCount() + 1);
        baseMapper.updateById(course);

        // 根据课程 id 查询课程详情
        CourseVo courseVo = baseMapper.selectCourseVoById(courseId);
        // 课程章节小节数据
        List<ChapterVo> chapterVoList = chapterService.getTreeList(courseId);
        // 课程描述信息
        CourseDescription courseDescription = courseDescriptionService.getById(courseId);
        // 查询所属讲师信息
        Teacher teacher = teacherService.getById(course.getTeacherId());

        // 查询用户是否购买该课程<远程调用>
        Boolean idBuy = false;
        Result<String> result = orderInfoFeignClient.getOrderStatus(course.getId());
        if (!Result.SUCCESS_CODE.equals(result.getCode())) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
        }

        String orderStatus = result.getData();
        if ("1".equals(orderStatus)) {
            idBuy = true;
        }

        // 创建 map 集合, 封装并返回数据
        Map<String, Object> map = new HashMap<>(2);
        map.put("courseVo", courseVo);
        map.put("chapterVoList", chapterVoList);
        map.put("description", null != courseDescription ? courseDescription.getDescription() : "");
        map.put("teacher", teacher);
        // 是否购买
        map.put("isBuy", idBuy);
        return map;
    }

    @Override
    public List<Course> findList() {
        return baseMapper.selectList(null).stream().peek(course -> {
            // 封装数据
            // 根据讲师 id 获取讲师名称
            Teacher teacher = teacherService.getById(course.getTeacherId());
            if (teacher != null) {
                String name = teacher.getName();
                course.getParam().put("teacherName", name);
            }

            // 根据课程分类 id 获取课程分类名称
            Subject subjectOne = subjectService.getById(course.getSubjectParentId());
            if (subjectOne != null) {
                course.getParam().put("subjectParentTitle", subjectOne.getTitle());
            }

            Subject subjectTwo = subjectService.getById(course.getSubjectId());
            if (subjectTwo != null) {
                course.getParam().put("subjectTitle", subjectTwo.getTitle());
            }
        }).collect(Collectors.toList());
    }

}
