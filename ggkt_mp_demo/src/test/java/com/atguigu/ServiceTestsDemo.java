package com.atguigu;

import com.atguigu.entity.User;
import com.atguigu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/10/1 07:46
 */
@SpringBootTest
public class ServiceTestsDemo {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        List<User> list = userService.list();
        System.out.println(list);
    }

}
