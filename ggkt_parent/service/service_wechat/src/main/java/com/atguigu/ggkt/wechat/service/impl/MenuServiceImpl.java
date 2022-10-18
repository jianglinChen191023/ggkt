package com.atguigu.ggkt.wechat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.model.wechat.Menu;
import com.atguigu.ggkt.vo.wechat.MenuVo;
import com.atguigu.ggkt.wechat.config.WxProperties;
import com.atguigu.ggkt.wechat.mapper.MenuMapper;
import com.atguigu.ggkt.wechat.service.MenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxProperties wxProperties;

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
                                if (menuVo.getChildren() == null) {
                                    menuVo.setChildren(new ArrayList<>());
                                }

                                menuVo.getChildren().add(menuVoTwo);
                            });
                })
                .collect(Collectors.toList());
    }

    @Override
    public void syncMenu() {
        // 获取所有菜单
        List<MenuVo> menuVoList = this.findMenuInfo();
        // 封装数据
        // 创建 button 数组
        JSONArray buttonList = new JSONArray();
        menuVoList.stream()
                .forEach(menuVo -> {
                    // 一级菜单
                    // 创建一级菜单对象
                    JSONObject oneObject = new JSONObject();
                    oneObject.put("name", menuVo.getName());
                    // 二级菜单
                    // 创建二级菜单数组
                    JSONArray twoArray = new JSONArray();
                    menuVo.getChildren().forEach(menuVoTwo -> {
                        // 获取对象属性
                        String name = menuVoTwo.getName();
                        String type = menuVoTwo.getType();
                        // 创建二级菜单对象
                        JSONObject twoObject = new JSONObject();
                        twoObject.put("type", type);
                        twoObject.put("name", name);
                        // 判断类型
                        // view 表示网页类型，click 表示点击类型，miniprogram 表示小程序类型
                        String view = "view";
                        String click = "click";
                        if (view.equals(type)) {
                            twoObject.put("url", wxProperties.getViewUrl() + menuVoTwo.getUrl());
                        } else if (click.equals(type)) {
                            twoObject.put("key", menuVoTwo.getMeunKey());
                        }

                        twoArray.add(twoObject);
                    });

                    oneObject.put("sub_button", twoArray);
                    buttonList.add(oneObject);
                });

        JSONObject button = new JSONObject();
        button.put("button", buttonList);
        try {
            // 同步菜单
            wxMpService.getMenuService().menuCreate(button.toJSONString());
        } catch (WxErrorException e) {
            throw new GgktException(20001, "公众号菜单同步失败");
        }
    }

    @Override
    public void removeMenu() {
        try {
            wxMpService.getMenuService().menuDelete();
        } catch (WxErrorException e) {
            throw new GgktException(20001, "公众号菜单删除失败");
        }
    }

}
