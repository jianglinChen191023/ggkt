package com.atguigu.ggkt.util;

import lombok.SneakyThrows;

import java.util.Base64;
import java.util.regex.Pattern;

/**
 * @author 陈江林
 * @date 2022/11/5 00:05
 */
public class Base64Util {

    /**
     * 使用Base64进行加密
     *
     * @param content 密文
     * @return
     */
    @SneakyThrows
    public static String base64Encode(String content) {
        return Base64.getEncoder().encodeToString(content.getBytes("UTF-8"));
    }

    /**
     * 使用Base64进行解密
     *
     * @param content
     * @return
     */
    @SneakyThrows
    public static String base64Decode(String content) {
        return new String(Base64.getDecoder().decode(content), "UTF-8");
    }

    public static boolean isNumeric(String str) {
        String regex = "^[1-9][0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }

}