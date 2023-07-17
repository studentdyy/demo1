package com.example.demo.base.enums;

import lombok.Getter;

/**
 * @Description 统一结果返回状态码
 * @Author liaozhenyuan
 * @Date 2022/6/16 14:54
 * @Version
 **/
@Getter
public enum ResultCodeEnum {
    /**
     * 常见的状态码被分为五大类：
     *
     * 100-199 用于指定客户端应相应的某些动作。
     * 200-299 用于表示请求成功。
     * 300-399 用于已经移动的文件并且常被包含在定位头信息中指定新的地址信息。
     * 400-499 用于指出客户端的错误。
     * 500-599 用于支持服务器错误
     */

    /** 成功 */
    SUCCESS(true, 200, "成功"),
    /** 未知错误 */
    UNKNOWN_ERROR(false,400,"未知错误"),
    /** 参数校验失败 */
    VALIDATE_FAILED(false,401,"参数校验失败"),
    /** 空指针错误 */
    NULL_POINT(false,506,"空指针错误"),
    /**登录验证失败*/
    LOGIN_ACCOUNT_NULL(false,530,"用户账号或密码为空"),
    /**登录验证失败*/
    LOGIN_FAILED(false,531,"用户账号或密码错误"),
    /**登录验证失败-账户不存在*/
    LOGIN_FAILED_NOT_ACCOUNT(false,532,"账户不存在"),
    /**登录验证失败-密码错误*/
    LOGIN_FAILED_PASSWORD(false,533,"密码错误"),
    /** 用户登录过期 */
    LOGIN_EXPIRATION(false,534,"登录已过期，请重新登录"),
    /** 用户已存在 */
    USER_IS_EXIST(false,535,"用户已存在"),
    /** 用户已锁定 */
    USER_IS_LOCK(false,536,"用户已被锁定，请联系管理员解锁！"),

    /** 没有权限进行操作 */
    PERMISSION_FAIL(false, 537, "温馨提示：您无权限进行此操作！"),
    /**系统错误*/
    SYS_ERROR(false,500,"系统错误!"),

    ;


    /** 响应是否成功 */
    private Boolean success;
    /** 响应状态码 */
    private Integer code;
    /** 响应信息 */
    private String message;

    ResultCodeEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
