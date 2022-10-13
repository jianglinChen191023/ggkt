package com.atguigu.ggkt.wechat.service;

import com.atguigu.ggkt.model.wechat.Menu;
import com.atguigu.ggkt.vo.wechat.MenuVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 微信公众号菜单 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
public interface MenuService extends IService<Menu> {

    /**
     * 获取所有一级菜单
     *
     * @return {@link List}<{@link Menu}>
     */
    List<Menu> findMenuOneInfo();

    /**
     * 获取所有菜单，按照一级和二级菜单封装
     *
     * @return {@link List}<{@link MenuVo}>
     */
    List<MenuVo> findMenuInfo();

}
