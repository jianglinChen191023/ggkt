package com.atguigu.ggkt.client.course;

import com.atguigu.ggkt.model.vod.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/10/15 14:05
 */
@FeignClient(value = "service-vod")
public interface CourseFeignClient {

    /**
     * 根据关键字查询课程
     *
     * @param keyword 关键字
     * @return {@link List}<{@link Course}>
     */
    @GetMapping("/api/vod/course/inner/findByKeyword/{keyword}")
    List<Course> findByKeyword(@PathVariable String keyword);

}
