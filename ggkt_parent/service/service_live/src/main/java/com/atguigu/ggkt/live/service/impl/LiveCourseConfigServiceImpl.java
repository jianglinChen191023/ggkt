package com.atguigu.ggkt.live.service.impl;

import com.atguigu.ggkt.live.mapper.LiveCourseConfigMapper;
import com.atguigu.ggkt.live.service.LiveCourseConfigService;
import com.atguigu.ggkt.model.live.LiveCourseConfig;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 直播课程配置表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
@Service
public class LiveCourseConfigServiceImpl extends ServiceImpl<LiveCourseConfigMapper, LiveCourseConfig> implements LiveCourseConfigService {

    @Override
    public LiveCourseConfig getCourseConfigByLiveCourseId(Long id) {
        return baseMapper.selectOne(
                new LambdaQueryWrapper<LiveCourseConfig>()
                        .eq(LiveCourseConfig::getLiveCourseId, id)
        );
    }

}
