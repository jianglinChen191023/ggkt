package com.atguigu.ggkt.live.service.impl;

import com.atguigu.ggkt.live.mapper.LiveCourseAccountMapper;
import com.atguigu.ggkt.live.service.LiveCourseAccountService;
import com.atguigu.ggkt.model.live.LiveCourseAccount;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 直播课程账号表（受保护信息） 服务实现类
 * </p>
 *
 * @autho 陈江林
 * @since 2022-11-01
 */
@Service
public class LiveCourseAccountServiceImpl extends ServiceImpl<LiveCourseAccountMapper, LiveCourseAccount> implements LiveCourseAccountService {

    @Override
    public LiveCourseAccount getLiveCourseAccountByLiveCourseId(Long id) {
        // 查询一条记录
        return baseMapper.selectOne(
                // 创建条件对象
                new LambdaQueryWrapper<LiveCourseAccount>()
                        // 直播课程 id
                        .eq(LiveCourseAccount::getLiveCourseId, id)
        );
    }

}
