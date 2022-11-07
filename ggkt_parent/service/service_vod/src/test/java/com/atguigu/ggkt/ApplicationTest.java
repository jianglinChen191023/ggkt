package com.atguigu.ggkt;

import com.atguigu.ggkt.vod.service.CourseService;
import com.atguigu.ggkt.vod.service.VodService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/10/21 11:13
 */
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private VodService vodService;

    @SneakyThrows
    public static void main(String[] args) {
//        Map<String, String> resultMap =new HashMap<>();
//        resultMap.put("1", "2");
//        System.out.println(resultMap.toString());

        // 2021-11-26 10:36:13
        String a = "20211126103613";

        Date parse = new SimpleDateFormat("yyyyMMddHHmmss").parse(a);
        System.out.println(parse);
    }


    @Test
    public void test() {
        System.out.println(courseService.findPage(1L, 1L, 10L).get("records"));
    }

    @Test
    public void getInfoById() {
        Map<String, Object> infoById = courseService.getInfoById(4L);
        System.out.println("infoById: " + infoById);
    }

    @Test
    public void getPlayAuth() {
        System.out.println(vodService.getPlayAuth(6L));
    }

}
