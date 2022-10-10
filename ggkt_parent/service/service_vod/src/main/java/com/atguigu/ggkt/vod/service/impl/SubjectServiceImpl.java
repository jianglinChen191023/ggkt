package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.vod.mapper.SubjectMapper;
import com.atguigu.ggkt.vod.service.SubjectService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程分类 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-10
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public List<Subject> selectSubjectList(Long id) {
        LambdaQueryWrapper<Subject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Subject::getParentId, id);
        List<Subject> list = baseMapper.selectList(wrapper);
        list.forEach(subject -> {
            // 判断是否有子数据, 如果有设置 hashChildren = true
            Long subjectId = subject.getId();
            // 查询
            boolean isChild = this.isChildren(subjectId);
            subject.setHasChildren(isChild);
        });

        return list;
    }

    /**
     * 判断是否有子数据
     *
     * @param subjectId 对象 id
     * @return boolean
     */
    public boolean isChildren(Long subjectId) {
        LambdaQueryWrapper<Subject> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Subject::getParentId, subjectId);
        Integer count = baseMapper.selectCount(wrapper);
        return count > 0;
    }

}
