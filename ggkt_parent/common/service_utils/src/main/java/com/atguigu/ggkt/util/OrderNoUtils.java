package com.atguigu.ggkt.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单工具类
 *
 * @author 陈江林
 * @date 2022/10/21 21:07
 */
public class OrderNoUtils {

    /**
     * 获取订单号
     *
     * @return
     */
    public static String getOrderNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            result += random.nextInt(10);
        }

        return newDate + result;
    }

}
