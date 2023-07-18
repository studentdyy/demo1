package com.example.demo.excel;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dyy
 * @version 0.1
 * @date 2022/9/5 8:34
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelImport {

    /** 字段名称 */
    String value();

    /** 导出映射，格式如：0-未知;1-男;2-女 */
    String kv() default "";

    /** 是否为必填字段（默认为非必填） */
    boolean required() default false;

    /** 最大长度（默认255） */
    int maxLength() default 255;

    /** 最小长度（默认1） */
    int minLength() default 1;

    /** 长度（默认0） */
    int length() default 0;

    /** 导入唯一性验证（多个字段则取联合验证） */
    boolean unique() default false;

    /** 日期验证,是否在今天之前 */
    boolean beforeNow() default false;

    /** 手机号码验证 */
    boolean isPhoneNumber() default false;

    /** 身份证验证 */
    boolean isIdCard() default false;

}