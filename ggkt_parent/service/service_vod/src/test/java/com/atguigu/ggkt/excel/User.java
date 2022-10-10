package com.atguigu.ggkt.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EasyExcel 测试实体类
 *
 * @author 陈江林
 * @date 2022/10/10 13:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ExcelProperty("用户编号")
    private Integer id;

    @ExcelProperty("用户名称")
    private String name;

}
