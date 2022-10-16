package com.atguigu.ggkt.exception;

import com.atguigu.ggkt.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局统一异常处理
 *
 * @author 陈江林
 * @date 2022/10/3 12:08
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.fail().message("程序遇到一点点意外! 请稍后再试");
    }

    /**
     * 特定异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(ArithmeticException.class)
    public Result error(ArithmeticException e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.fail().message("执行 ArithmeticException 异常处理");
    }

    /**
     * 自定义异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(GgktException.class)
    public Result error(GgktException e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }

}
