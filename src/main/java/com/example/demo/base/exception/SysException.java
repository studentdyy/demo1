package com.example.demo.base.exception;

import com.example.demo.base.enums.ResultCodeEnum;
import lombok.Data;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/17 14:40
 */

@Data
public class SysException extends RuntimeException {

    private Integer code;
    private String msg;

    public SysException(String message) {
        super(message);
        this.msg = message;
        this.code = 500;
    }

    public SysException(Integer code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public SysException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "SysException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
