package com.atguigu.ggkt.live.service.impl;

import com.atguigu.ggkt.live.mapper.LiveCourseGoodsMapper;
import com.atguigu.ggkt.live.service.LiveCourseGoodsService;
import com.atguigu.ggkt.model.live.LiveCourseGoods;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 直播课程关联推荐表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
@Service
public class LiveCourseGoodsServiceImpl extends ServiceImpl<LiveCourseGoodsMapper, LiveCourseGoods> implements LiveCourseGoodsService {

    @Override
    public List<LiveCourseGoods> getLiveCourseGoodsListByLiveCourseId(Long id) {
        // 查询所有记录
        return baseMapper.selectList(
                // 创建条件对象
                new LambdaQueryWrapper<LiveCourseGoods>()
                        // 直播课程 id
                        .eq(LiveCourseGoods::getLiveCourseId, id)
        );
    }

}
