package com.atguigu.ggkt.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 结果
 * 统一返回结果类, 全局统一返回结果
 *
 * @author 陈江林
 * @date 2022/10/2 09:36
 */
@ApiModel(value = "全局统一返回结果")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    /**
     * 状态码
     */
    @ApiModelProperty(value = "返回码")
    private Integer code;

    /**
     * 返回消息（成功、失败...）
     */
    @ApiModelProperty(value = "返回消息")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T data;

    /**
     * 成功的方法, 没有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    /**
     * 成功的方法, 有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(20000, "成功", data);
    }

    /**
     * 失败的方法, 没有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail() {
        return Result.fail(null);
    }

    /**
     * 失败的方法, 有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail(T data) {
        return new Result<>(20001, "失败", data);
    }

    /**
     * 修改状态码
     *
     * @param code 状态码
     * @return {@link Result}<{@link T}>
     */
    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 修改消息
     *
     * @param message 消息
     * @return {@link Result}<{@link T}>
     */
    public Result<T> message(String message) {
        this.setMessage(message);
        return this;
    }

}
