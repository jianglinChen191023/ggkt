package com.atguigu.ggkt;

import com.alibaba.excel.EasyExcel;
import com.atguigu.ggkt.excel.User;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试 EasyExcel 写入 Excel
 *
 * @author 陈江林
 * @date 2022/10/10 13:40
 */
public class TestWrite {

    public static void main(String[] args) {
        String fileName = TestWrite.class.getResource("/").getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        System.out.println(fileName);
        EasyExcel.write(fileName, User.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });

        try {
            // 打开文件
            Desktop.getDesktop().open(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<User> data() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(i, "lucy" + i);
            list.add(user);
        }

        return list;
    }

}
