package com.atguigu.ggkt.live.service;

import com.atguigu.ggkt.model.live.LiveCourseGoods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 直播课程关联推荐表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
public interface LiveCourseGoodsService extends IService<LiveCourseGoods> {

    /**
     * 根据直播课程 id 查询直播课程商品列表
     *
     * @param id 直播课程 id
     * @return {@link List}<{@link LiveCourseGoods}>
     */
    List<LiveCourseGoods> getLiveCourseGoodsListByLiveCourseId(Long id) ;

}
