package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.VideoVisitor;
import com.atguigu.ggkt.vo.vod.VideoVisitorCountVo;
import com.atguigu.ggkt.vod.mapper.VideoVisitorMapper;
import com.atguigu.ggkt.vod.service.VideoVisitorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 课程统计 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor> implements VideoVisitorService {

    @Override
    public Map<String, Object> findCount(Long courseId, String startDate, String endDate) {
        // 创建 Map 对象
        Map<String, Object> map = new HashMap<>();
        // 查询数据
        List<VideoVisitorCountVo> videoVisitorCountVoList = baseMapper.findCount(courseId, startDate, endDate);
        // Echarts 需要两个集合(日期, 数据)
        List<String> dateList = videoVisitorCountVoList.stream()
                .map(videoVisitorCountVo -> {
                    Date joinTime = videoVisitorCountVo.getJoinTime();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String format = simpleDateFormat.format(joinTime);
                    return format;
                })
                .collect(Collectors.toList());
        List<Integer> dataList = videoVisitorCountVoList.stream()
                .map(VideoVisitorCountVo::getUserCount).collect(Collectors.toList());

        map.put("xData", dateList);
        map.put("yData", dataList);
        return map;
    }

}
