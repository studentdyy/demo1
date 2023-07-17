package com.example.demo.base.exception;

import com.example.demo.base.bean.ResultBean;
import com.example.demo.base.enums.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/17 14:40
 */

@ControllerAdvice
public class GlobalExceptionHandler {


    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 通用异常处理方法
     * （@ExceptionHandler注解捕获指定或自定义的异常）
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean error(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        log.error("请求地址'{}',发生未知异常.", request.getRequestURI(), e);
        // 通用异常结果
        return ResultBean.error();
    }


    /**
     * 指定异常处理方法——空指针异常
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResultBean error(NullPointerException e, HttpServletRequest request) {
        e.printStackTrace();
        log.error("请求地址'{}',发生空指针异常.", request.getRequestURI(), e);
        // 通用异常结果
        return ResultBean.setResult(ResultCodeEnum.NULL_POINT);
    }

    /**
     * 指定异常处理方法——下标溢出异常
     * @param e
     * @return
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public ResultBean error(IndexOutOfBoundsException e, HttpServletRequest request) {
        e.printStackTrace();
        log.error("请求地址'{}',发生下标溢出异常.", request.getRequestURI(), e);
        // 通用异常结果
        return ResultBean.error().message("下标溢出");
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultBean error(HttpMessageNotReadableException e) {
        e.printStackTrace();
        return ResultBean.error().message("传输数据类型异常！\n" + e.getMessage());
    }



    /**
     * 请求方式不支持异常
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResultBean error(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        e.printStackTrace();
        log.error("请求地址'{}',不支持'{}'请求", request.getRequestURI(), e.getMethod());
        return ResultBean.error().message("请求方式错误，请核定请求方式！");
    }


    /**
     * 通常是Assert方法的异常
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResultBean error(IllegalArgumentException e) {
        e.printStackTrace();
        return ResultBean.error().message(e.getMessage());
    }


    // 绑定异常
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean error(BindException e) {
        e.printStackTrace();
        return ResultBean.error().message(e.getMessage());
    }



    /**
     * {@code @RequestBody} 参数校验不通过时抛出的异常处理
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ResultBean<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String msg = fieldError.getDefaultMessage();
            if (!StringUtils.isEmpty(msg)) {
                return ResultBean.error(ResultCodeEnum.VALIDATE_FAILED.getCode(), msg);
            }
        }


        return ResultBean.error(ResultCodeEnum.VALIDATE_FAILED);
    }

    /**
     * 指定异常处理方法——自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(SysException.class)
    @ResponseBody
    public ResultBean error(SysException e) {
//        e.printStackTrace();
        // 通用异常结果
        return ResultBean.error().message(e.getMessage()).code(e.getCode());
    }
}
