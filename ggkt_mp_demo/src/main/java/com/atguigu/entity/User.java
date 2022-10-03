package com.atguigu.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 陈江林
 * @date 2022/9/22 12:49
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;

    /**
     * 逻辑删除 [{0: "没有删除"}, {1: "已经删除"}]
     */
    @TableLogic
    private Integer deleted;
}
