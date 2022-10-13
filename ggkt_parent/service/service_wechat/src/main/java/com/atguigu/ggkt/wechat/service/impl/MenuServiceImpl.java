package com.atguigu.ggkt.wechat.service.impl;

import com.atguigu.ggkt.model.wechat.Menu;
import com.atguigu.ggkt.vo.wechat.MenuVo;
import com.atguigu.ggkt.wechat.mapper.MenuMapper;
import com.atguigu.ggkt.wechat.service.MenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 微信公众号菜单 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public List<Menu> findMenuOneInfo() {
        // 创建条件对象
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper();
        // eq(=)
        wrapper.eq(Menu::getParentId, 0);
        // 查询并返回
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<MenuVo> findMenuInfo() {
        // 查询所有菜单数据（包含一级和二级）
        List<MenuVo> menuVoList = baseMapper.selectList(Wrappers.emptyWrapper()).stream()
                // 将对象转换成 MenuVo
                .map(menu -> {
                    MenuVo menuVo = new MenuVo();
                    BeanUtils.copyProperties(menu, menuVo);
                    return menuVo;
                })
                .collect(Collectors.toList());

        // 取出二级菜单
        List<MenuVo> menuVoTwoList = menuVoList.stream()
                .filter(menu -> !menu.getParentId().equals(0L))
                .collect(Collectors.toList());

        // 取出一级菜单并遍历找到对应的二级菜单
        return menuVoList.stream()
                // 从所有菜单数据中取出一级菜单（parent_id = 0）
                .filter(menu -> menu.getParentId().equals(0L))
                // 遍历
                .peek(menuVo -> {
                    // 获取当前一级菜单的 id
                    Long id = menuVo.getId();
                    menuVoTwoList.stream()
                            // 过滤出对应的二级菜单
                            .filter(menuVoTwo -> menuVoTwo.getParentId().equals(id))
                            // 将对应的二级菜单存储到一级菜单的子集合中
                            .forEach(menuVoTwo -> {
                                menuVo.getChildren().add(menuVoTwo);
                            });
                })
                .collect(Collectors.toList());
    }

}
