package com.atguigu.ggkt;

import com.atguigu.ggkt.vod.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/10/21 11:13
 */
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void test() {
        System.out.println(courseService.findPage(1L, 1L, 10L).get("records"));
    }

    @Test
    public void getInfoById() {
        Map<String, Object> infoById = courseService.getInfoById(4L);
        System.out.println("infoById: "+ infoById);
    }

}
