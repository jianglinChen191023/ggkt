package com.atguigu.ggkt;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.atguigu.ggkt.excel.User;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试 EasyExcel 读取 Excel
 *
 * @author 陈江林
 * @date 2022/10/10 13:53
 */
@Slf4j
public class TestRead {

    public static void main(String[] args) {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "/Users/chenjianglin/IdeaProjects/ggkt/ggkt_parent/service/service_vod/target/test-classes/simpleWrite1665381066271.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取100条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, User.class, new PageReadListener<User>(dataList -> {
            for (User user : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(user));
            }
        })).sheet().doRead();
    }

}
