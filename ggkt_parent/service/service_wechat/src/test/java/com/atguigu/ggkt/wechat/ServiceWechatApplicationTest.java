package com.atguigu.ggkt.wechat;

import com.atguigu.ggkt.vo.wechat.MenuVo;
import com.atguigu.ggkt.wechat.service.MenuService;
import com.atguigu.ggkt.wechat.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 陈江林
 * @date 2022/10/13 21:29
 */
@SpringBootTest
public class ServiceWechatApplicationTest {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MessageService messageService;

    /**
     * 测试发送模板消息
     */
    @Test
    public void TestSendMessage() {
        messageService.pushPayMessage(0L);
    }

    public static void main(String[] args) {
        MenuVo menuVoTwo = new MenuVo();
        menuVoTwo.setId(1L);

        // 一
        List<MenuVo> menuInfo1 = Arrays.asList(menuVoTwo);
        System.out.println("Arrays" + menuInfo1);

        // 二
        List<MenuVo> menuVoList = Collections.singletonList(menuVoTwo);
        System.out.println("Collections" + menuVoList);
    }

    @Test
    public void selectTest() {
        List<MenuVo> menuInfo = menuService.findMenuInfo();
        System.out.println(menuInfo);
    }

    @Test
    public void syncMenu() {
        menuService.syncMenu();
    }

    @Test
    public void removeMenu() {
        menuService.removeMenu();
    }
}
