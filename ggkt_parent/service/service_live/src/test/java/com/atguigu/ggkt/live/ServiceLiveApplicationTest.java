package com.atguigu.ggkt.live;

import com.atguigu.ggkt.live.service.LiveCourseService;
import com.atguigu.ggkt.vo.live.LiveCourseVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/10/29 23:43
 */
@SpringBootTest
public class ServiceLiveApplicationTest {

    @Autowired
    private LiveCourseService liveCourseService;

    @Test
    public void getTest() {
        List<LiveCourseVo> latelyList = liveCourseService.getLatelyList();
        System.out.println(latelyList);
    }

}
