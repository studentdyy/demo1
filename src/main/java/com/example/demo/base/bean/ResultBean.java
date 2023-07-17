package com.example.demo.base.bean;

import com.example.demo.base.enums.ResultCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Optional;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/17 11:27
 */
@Data
@JsonInclude
public class ResultBean<T> {
    /** 响应是否成功 */
    private Boolean success;
    /** 响应状态码 */
    private Integer code;
    /** 响应数据 */
    private T data;
    /** 响应信息 */
    private String message;


    /**
     * 通用返回-成功
     * @return
     */
    public static ResultBean ok() {
        return new ResultBean(ResultCodeEnum.SUCCESS);
    }

    /**
     * 通用返回-成功（携带数据）
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultBean ok(Optional<T> data) {
        return new ResultBean(ResultCodeEnum.SUCCESS, data);
    }

    /**
     * 通用返回-成功（携带数据）
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultBean ok(T data) {
        return new ResultBean(ResultCodeEnum.SUCCESS, data);
    }

    /**
     * 通用返回失败，未知错误
     * @return
     */
    public static ResultBean error() {
        return new ResultBean(ResultCodeEnum.SYS_ERROR);
    }

    /**
     * 返回失败，带错误信息
     * @return
     */
    public static ResultBean error(ResultCodeEnum resultCodeEnum) {
        return new ResultBean(resultCodeEnum);
    }

    /**
     * 通用返回失败，未知错误
     * @return
     */
    public static ResultBean error(Integer code, String msg) {
        return new ResultBean(false, code, msg);
    }

    /**
     * 设置结果，参数为结果枚举
     * @param resultCodeEnum
     * @return
     */
    public static ResultBean setResult(ResultCodeEnum resultCodeEnum) {
        return new ResultBean(resultCodeEnum);
    }

    /** -------------- 使用链式变成，返回类本身 ------------------ */

    /** 自定义返回结果 */
    public ResultBean success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    /** 自定义返回状态码 */
    public ResultBean code(Integer code) {
        this.setCode(code);
        return this;
    }

    /** 自定义返回数据 */
    public ResultBean data(T data) {
        this.setData(data);
        return this;
    }

    /** 自定义返回响应信息 */
    public ResultBean message(String message) {
        this.setMessage(message);
        return this;
    }


    // =======================构造函数=======================

    public ResultBean() {
    }

    private ResultBean(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    private ResultBean(Boolean success, Integer code, T data, String message) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.message = message;
    }


    private ResultBean(ResultCodeEnum resultCodeEnum) {
        this.success = resultCodeEnum.getSuccess();
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    private ResultBean(ResultCodeEnum resultCodeEnum, T data) {
        this.success = resultCodeEnum.getSuccess();
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.data = data;
    }
}
