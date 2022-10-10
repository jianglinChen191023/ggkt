package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 课程分类 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-10
 */
public interface SubjectService extends IService<Subject> {

    /**
     * 查询课程分类列表
     *
     * @param id id
     * @return {@link List}<{@link Subject}>
     */
    List<Subject> selectSubjectList(Long id);

    /**
     * 导出数据为 Excel 文件
     *
     * @param response 响应
     */
    void exportData(HttpServletResponse response);

    /**
     * 导入数据
     *
     * @param file 文件
     */
    void importData(MultipartFile file);
}
