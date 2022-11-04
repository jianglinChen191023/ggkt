package com.atguigu.ggkt.live.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import com.atguigu.ggkt.client.course.CourseFeignClient;
import com.atguigu.ggkt.client.user.UserInfoFeignClient;
import com.atguigu.ggkt.constant.GgktConstant;
import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.live.mapper.LiveCourseMapper;
import com.atguigu.ggkt.live.mtcloud.CommonResult;
import com.atguigu.ggkt.live.mtcloud.MTCloud;
import com.atguigu.ggkt.live.service.*;
import com.atguigu.ggkt.model.live.*;
import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.util.AuthContextHolder;
import com.atguigu.ggkt.util.DateUtil;
import com.atguigu.ggkt.vo.live.LiveCourseConfigVo;
import com.atguigu.ggkt.vo.live.LiveCourseFormVo;
import com.atguigu.ggkt.vo.live.LiveCourseGoodsView;
import com.atguigu.ggkt.vo.live.LiveCourseVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 直播课程表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
@Slf4j
@Service
public class LiveCourseServiceImpl extends ServiceImpl<LiveCourseMapper, LiveCourse> implements LiveCourseService {

    @Autowired
    private CourseFeignClient courseFeignClient;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    @Autowired
    private MTCloud mtCloud;

    @Autowired
    private LiveCourseDescriptionService liveCourseDescriptionService;

    @Autowired
    private LiveCourseAccountService liveCourseAccountService;

    @Autowired
    private LiveCourseConfigService liveCourseConfigService;

    @Autowired
    private LiveCourseGoodsService liveCourseGoodsService;

    @Override
    public IPage<LiveCourse> selectPage(Page<LiveCourse> pageParam) {
        // 分页查询
        Page<LiveCourse> liveCoursePage = baseMapper.selectPage(pageParam, Wrappers.emptyWrapper());
        // 遍历数据, 修改引用类型数据
        liveCoursePage.getRecords().forEach(liveCourse -> {
            // - 获取课程讲师信息
            // - - 获取讲师 id
            Long teacherId = liveCourse.getTeacherId();
            // - - 根据讲师 id 查询讲师信息（远程调用 vod 模块）
            Result<Teacher> teacherResult = courseFeignClient.getTeacherId(teacherId);
            if (!Result.SUCCESS_CODE.equals(teacherResult.getCode())) {
                throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
            }

            // 得到数据
            Teacher teacher = teacherResult.getData();

            // - 向引用类型 map 中添加数据
            liveCourse.getParam().put("teacherName", teacher.getName());
            liveCourse.getParam().put("teacherLevel", teacher.getLevel());
        });

        return liveCoursePage;
    }

    @Override
    public void saveLive(LiveCourseFormVo liveCourseFormVo) {
        if (liveCourseFormVo == null) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_PARAM);
        }

        // liveCourseFormVo -> liveCourse
        // 创建直播课程对象
        LiveCourse liveCourse = new LiveCourse();
        // 复制属性
        BeanUtils.copyProperties(liveCourseFormVo, liveCourse);

        // - 获取讲师信息
        // - - 获取讲师 id
        Long teacherId = liveCourseFormVo.getTeacherId();
        // - - 根据讲师 id 查询讲师信息（远程调用 vod 模块）
        Result<Teacher> teacherResult = courseFeignClient.getTeacherId(teacherId);
        if (!Result.SUCCESS_CODE.equals(teacherResult.getCode())) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
        }

        // 得到数据
        Teacher teacher = teacherResult.getData();

        // - 添加直播课程（第三方接口）
        // - - 创建 map 集合（其他参数）, 封装直播课程其他参数
        HashMap<Object, Object> options = new HashMap<>();
        // 直播类型。1: 教育直播，2: 生活直播。默认 1，说明：根据平台开通的直播类型填写
        options.put("scenes", 2);
        options.put("password", liveCourseFormVo.getPassword());

        log.info(new DateTime(liveCourse.getStartTime()).toString("yyyy-MM-dd HH:mm:ss"));
        try {
            String result = mtCloud.courseAdd(
                    liveCourse.getCourseName(),
                    teacher.getId().toString(),
                    new DateTime(liveCourse.getStartTime()).toString("yyyy-MM-dd HH:mm:ss"),
                    new DateTime(liveCourse.getEndTime()).toString("yyyy-MM-dd HH:mm:ss"),
                    teacher.getName(),
                    teacher.getIntro(),
                    options
            );

            // - 返回结果
            // - - 处理返回结果
            CommonResult<JSONObject> commonResult = JSON.parseObject(result, CommonResult.class);
            if (Integer.parseInt(commonResult.getCode()) != MTCloud.CODE_SUCCESS) {
                // - - 直播课程添加失败
                throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_COURSE);
            }

            // - - 直播课程添加成功
            // 得到返回数据
            JSONObject object = commonResult.getData();

            // - 添加直播基本信息
            // - - 获取直播课程 id
            Long course_id = object.getLong("course_id");
            liveCourse.setCourseId(course_id);
            // 保存信息
            baseMapper.insert(liveCourse);

            // - 添加直播描述信息
            // -- 创建直播课程描述对象
            LiveCourseDescription liveCourseDescription = new LiveCourseDescription();
            liveCourseDescription.setDescription(liveCourseFormVo.getDescription());
            liveCourseDescription.setLiveCourseId(liveCourse.getId());
            // 保存信息
            liveCourseDescriptionService.save(liveCourseDescription);

            // - 添加直播账号信息
            // -- 创建直播课程账户对象
            LiveCourseAccount liveCourseAccount = new LiveCourseAccount();
            liveCourseAccount.setLiveCourseId(liveCourse.getId());
            liveCourseAccount.setZhuboAccount(object.getString("bid"));
            liveCourseAccount.setZhuboPassword(liveCourseFormVo.getPassword());
            liveCourseAccount.setAdminKey(object.getString("admin_key"));
            liveCourseAccount.setUserKey(object.getString("user_key"));
            liveCourseAccount.setZhuboKey(object.getString("zhubo_key"));
            // 保存信息
            liveCourseAccountService.save(liveCourseAccount);
        } catch (Exception e) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_COURSE);
        }
    }

    @Override
    public void removeLiveById(Long id) {
        // 根据 id 查询直播课程信息
        LiveCourse liveCourse = baseMapper.selectById(id);
        if (liveCourse == null) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_PARAM);
        }

        // 获取直播课程 课程id
        Long courseId = liveCourse.getCourseId();
        try {
            // 删除直播课程（欢拓云接口）
            mtCloud.courseDelete(courseId.toString());
            // 删除本地数据
            // 删除直播基本信息
            baseMapper.deleteById(id);
            // - 删除直播描述信息
            // - - 创建条件对象
            LambdaQueryWrapper<LiveCourseDescription> wrapper = new LambdaQueryWrapper();
            wrapper.eq(LiveCourseDescription::getLiveCourseId, id);
            // 根据直播课程 id 删除
            liveCourseDescriptionService.remove(wrapper);

            // - 删除直播账号信息
            // 根据直播课程 id 删除
            liveCourseAccountService.remove(
                    new LambdaQueryWrapper<LiveCourseAccount>()
                            .eq(LiveCourseAccount::getLiveCourseId, id)
            );
        } catch (Exception e) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_COURSE_REMOVE);
        }
    }

    @Override
    public LiveCourseFormVo getLiveCourseVo(Long id) {
        // 获取直播课程的基本信息
        LiveCourse liveCourse = baseMapper.selectById(id);

        // 获取直播课程的描述信息
        LiveCourseDescription liveCourseDescription = liveCourseDescriptionService.getOne(
                new LambdaQueryWrapper<LiveCourseDescription>()
                        .eq(LiveCourseDescription::getLiveCourseId, id)
        );

        // 创建视图对象
        LiveCourseFormVo liveCourseFormVo = new LiveCourseFormVo();
        BeanUtils.copyProperties(liveCourse, liveCourseFormVo);
        liveCourseFormVo.setDescription(liveCourseDescription.getDescription());
        return liveCourseFormVo;
    }

    @Override
    public void updateLiveById(LiveCourseFormVo liveCourseFormVo) {
        // LiveCourseFormVo -> LiveCourse
        LiveCourse liveCourse = new LiveCourse();
        BeanUtils.copyProperties(liveCourseFormVo, liveCourse);

        // 根据 id 获取直播课程基本信息
        // - - 根据讲师 id 查询讲师信息（远程调用 vod 模块）
        Result<Teacher> teacherResult = courseFeignClient.getTeacherId(liveCourseFormVo.getTeacherId());
        if (!Result.SUCCESS_CODE.equals(teacherResult.getCode())) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
        }

        // 得到数据
        Teacher teacher = teacherResult.getData();

        HashMap<Object, Object> options = new HashMap<>();
        try {
            // 修改直播课程（欢拓云接口）
            String res = mtCloud.courseUpdate(liveCourse.getCourseId().toString(),
                    teacher.getId().toString(),
                    liveCourse.getCourseName(),
                    new DateTime(liveCourse.getStartTime()).toString("yyyy-MM-dd HH:mm:ss"),
                    new DateTime(liveCourse.getEndTime()).toString("yyyy-MM-dd HH:mm:ss"),
                    teacher.getName(),
                    teacher.getIntro(),
                    options);
            // 返回结果转换，判断是否成功
            CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);
            if (Integer.parseInt(commonResult.getCode()) != MTCloud.CODE_SUCCESS) {
                throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_COURSE_UPDATE);
            }

            // 获取欢拓云返回结果
            JSONObject object = commonResult.getData();
            // 更新直播课程基本信息
            liveCourse.setCourseId(object.getLong("course_id"));
            baseMapper.updateById(liveCourse);
            // - 直播课程描述信息更新
            // - - 根据直播课程 id 获取直播课程描述信息
            LiveCourseDescription liveCourseDescription = liveCourseDescriptionService.getOne(
                    new LambdaQueryWrapper<LiveCourseDescription>()
                            .eq(LiveCourseDescription::getLiveCourseId, liveCourse.getId())
            );
            liveCourseDescription.setDescription(liveCourseFormVo.getDescription());
            // - - 修改操作
            liveCourseDescriptionService.updateById(liveCourseDescription);
        } catch (Exception e) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_COURSE_UPDATE);
        }
    }

    @Override
    public LiveCourseConfigVo getCourseConfigByLiveCourseId(Long id) {
        // 创建 LiveCourseConfigVo 直播课程配置视图对象
        LiveCourseConfigVo liveCourseConfigVo = new LiveCourseConfigVo();

        // 根据直播课程 id 查询配置信息
        LiveCourseConfig liveCourseConfig = liveCourseConfigService.getCourseConfigByLiveCourseId(id);
        if (liveCourseConfig == null) {
            // 返回空对象
            return liveCourseConfigVo;
        }

        // 将查询到的配置信息复制到视图对象中
        BeanUtils.copyProperties(liveCourseConfig, liveCourseConfigVo);
        // 根据直播课程 id 查询直播课程商品列表
        List<LiveCourseGoods> liveCourseGoodsList = liveCourseGoodsService.getLiveCourseGoodsListByLiveCourseId(id);
        // 将查询到的商品数据添加到视图对象中
        liveCourseConfigVo.setLiveCourseGoodsList(liveCourseGoodsList);

        return liveCourseConfigVo;
    }

    @Override
    public void updateConfig(LiveCourseConfigVo liveCourseConfigVo) {
        // - 修改直播配置表
        // - - 创建直播课程配置对象
        LiveCourseConfig liveCourseConfig = new LiveCourseConfig();
        // - - 复制属性 LiveCourseConfigVo -> liveCourseConfig
        BeanUtils.copyProperties(liveCourseConfigVo, liveCourseConfig);
        // - - 判断是否有 id [{有id: 修改操作}, {无id: 添加操作}]
        /// if (liveCourseConfig.getId() != null) {
        ///     // 修改操作
        ///     liveCourseConfigService.updateById(liveCourseConfig);
        /// } else {
        ///     // 添加操作
        ///     liveCourseConfigService.save(liveCourseConfig);
        /// }
        // 简化
        liveCourseConfigService.saveOrUpdate(liveCourseConfig);

        // - 修改直播商品表
        // - - 根据直播课程 id 清空相关商品
        liveCourseGoodsService.remove(
                new LambdaQueryWrapper<LiveCourseGoods>()
                        .eq(LiveCourseGoods::getLiveCourseId, liveCourseConfigVo.getLiveCourseId())
        );

        // - - 批量添加商品
        List<LiveCourseGoods> liveCourseGoodsList = liveCourseConfigVo.getLiveCourseGoodsList();
        if (!CollectionUtils.isEmpty(liveCourseGoodsList)) {
            liveCourseGoodsService.saveBatch(liveCourseGoodsList);
        }

        // 调用欢拓云接口上传配置信息
        this.updateLifeConfig(liveCourseConfigVo);
    }

    /**
     * 上传直播配置
     *
     * @param liveCourseConfigVo
     */
    @SneakyThrows
    private void updateLifeConfig(LiveCourseConfigVo liveCourseConfigVo) {
        LiveCourse liveCourse = baseMapper.selectById(liveCourseConfigVo.getLiveCourseId());

        // 参数设置
        HashMap<Object, Object> options = new HashMap<>();
        // 界面模式
        options.put("pageViewMode", liveCourseConfigVo.getPageViewMode());
        // 观看人数开关
        JSONObject number = new JSONObject();
        number.put("enable", liveCourseConfigVo.getNumberEnable());
        options.put("number", number.toJSONString());
        // 观看人数开关
        JSONObject store = new JSONObject();
        number.put("enable", liveCourseConfigVo.getStoreEnable());
        number.put("type", liveCourseConfigVo.getStoreType());
        options.put("store", number.toJSONString());
        // 商城列表
        List<LiveCourseGoods> liveCourseGoodsList = liveCourseConfigVo.getLiveCourseGoodsList();
        if (!CollectionUtils.isEmpty(liveCourseGoodsList)) {
            List<LiveCourseGoodsView> liveCourseGoodsViewList = new ArrayList<>();
            liveCourseGoodsList.forEach(liveCourseGoods -> {
                LiveCourseGoodsView liveCourseGoodsView = new LiveCourseGoodsView();
                BeanUtils.copyProperties(liveCourseGoods, liveCourseGoodsView);
                liveCourseGoodsViewList.add(liveCourseGoodsView);
            });

            JSONObject goodsListEdit = new JSONObject();
            goodsListEdit.put("status", "0");
            options.put("goodsListEdit ", goodsListEdit.toJSONString());
            options.put("goodsList", JSON.toJSONString(liveCourseGoodsViewList));
        }

        String res = mtCloud.courseUpdateConfig(liveCourse.getCourseId().toString(), options);

        CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);
        if (Integer.parseInt(commonResult.getCode()) != MTCloud.CODE_SUCCESS) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_Config_UPDATE);
        }
    }

    @Override
    public List<LiveCourseVo> getLatelyList() {
        return baseMapper.getLatelyList()
                .stream()
                .peek(liveCourseVo -> {
                    // 封装开始和结束时间
                    liveCourseVo.setStartTimeString(new DateTime(liveCourseVo.getStartTime()).toString("yyyy年MM月dd HH:mm"));
                    liveCourseVo.setEndTimeString(new DateTime(liveCourseVo.getEndTime()).toString("HH:mm"));

                    // 根据讲师 id 获取讲师对象
                    Long teacherId = liveCourseVo.getTeacherId();
                    Result<Teacher> teacherResult = courseFeignClient.getTeacherId(teacherId);
                    if (!Result.SUCCESS_CODE.equals(teacherResult.getCode())) {
                        throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
                    }

                    // 得到数据
                    Teacher teacher = teacherResult.getData();
                    liveCourseVo.setTeacher(teacher);
                    // 封装直播状态 0：未开始 1：直播中 2：直播结束
                    liveCourseVo.setLiveStatus(this.getLiveStatus(liveCourseVo));
                }).collect(Collectors.toList());
    }

    /**
     * 直播状态 0：未开始 1：直播中 2：直播结束
     *
     * @param liveCourse
     * @return
     */
    private int getLiveStatus(LiveCourse liveCourse) {
        // 直播状态 0：未开始 1：直播中 2：直播结束
        int liveStatus = 0;
        Date curTime = new Date();
        if (DateUtil.dateCompare(curTime, liveCourse.getStartTime())) {
            liveStatus = 0;
        } else if (DateUtil.dateCompare(curTime, liveCourse.getEndTime())) {
            liveStatus = 1;
        } else {
            liveStatus = 2;
        }

        return liveStatus;
    }

    @Override
    public JSONObject getPlayAuth(Long id) {
        // 根据课程 id 获取直播课程信息
        LiveCourse liveCourse = baseMapper.selectById(id);
        // 根据用户 id 获取用户信息（远程调用）
        Result<UserInfo> userInfoResult = userInfoFeignClient.getById(AuthContextHolder.getUserId());
        if (!Result.SUCCESS_CODE.equals(userInfoResult.getCode())) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
        }

        // 得到数据
        UserInfo userInfo = userInfoResult.getData();
        if(userInfo == null) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_PARAM);
        }

        // 封装需要的参数
        HashMap<Object, Object> options = new HashMap<>();
        try {
            String res = mtCloud.courseAccess(
                    liveCourse.getCourseId().toString(),
                    AuthContextHolder.getUserId().toString(),
                    userInfo.getNickName(),
                    MTCloud.ROLE_USER,
                    3600,
                    options
            );
            // 欢拓云返回的参数
            CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);
            log.info("欢拓云Token-code: "+commonResult.getCode());
            log.info("欢拓云Token-data" + commonResult.getData().toString());
            if (MTCloud.CODE_SUCCESS != Integer.parseInt(commonResult.getCode())) {
                throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_ACCESS_TOKEN);
            }

            return commonResult.getData();
        } catch (Exception e) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_ACCESS_TOKEN);
        }
    }

    @Override
    public Map<String, Object> getInfoById(Long id) {
        LiveCourse liveCourse = this.getById(id);
        liveCourse.getParam().put("startTimeString", new DateTime(liveCourse.getStartTime()).toString("yyyy年MM月dd HH:mm"));
        liveCourse.getParam().put("endTimeString", new DateTime(liveCourse.getEndTime()).toString("yyyy年MM月dd HH:mm"));
        // 根据讲师 id 获取讲师对象
        Long teacherId = liveCourse.getTeacherId();
        Result<Teacher> teacherResult = courseFeignClient.getTeacherId(teacherId);
        if (!Result.SUCCESS_CODE.equals(teacherResult.getCode())) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
        }

        // 得到数据
        Teacher teacher = teacherResult.getData();
        LiveCourseDescription liveCourseDescription = liveCourseDescriptionService.getOne(
                new LambdaQueryWrapper<LiveCourseDescription>()
                        .eq(LiveCourseDescription::getLiveCourseId, id)
        );

        Map<String, Object> map = new HashMap<>();
        map.put("liveCourse", liveCourse);
        map.put("liveStatus", this.getLiveStatus(liveCourse));
        map.put("teacher", teacher);
        if (null != liveCourseDescription) {
            map.put("description", liveCourseDescription.getDescription());
        } else {
            map.put("description", "");
        }

        return map;
    }

}
