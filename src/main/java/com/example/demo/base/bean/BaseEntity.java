package com.example.demo.base.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/17 10:02
 */
public class BaseEntity {
    /** 创建人id */
    @ApiModelProperty("创建人id")
    @TableField(fill = FieldFill.INSERT)
    private Long createUserId;

    /** 创建人名 */
    @ApiModelProperty("创建人名")
    @TableField(fill = FieldFill.INSERT)
    private String createUserName;

    /** 创建时间 */
    @ApiModelProperty(value="创建时间",accessMode= ApiModelProperty.AccessMode.READ_ONLY,example="yyyy-MM-dd HH:mm:ss",readOnly = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")                // 反序列化时需要
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    /** 最后更新人id */
    @ApiModelProperty("最后更新人id")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUserId;

    /** 最后更新人名 */
    @ApiModelProperty("最后更新人名")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUserName;

    /** 最后更新时间 */
    @ApiModelProperty(value="修改时间",accessMode= ApiModelProperty.AccessMode.READ_ONLY,example="yyyy-MM-dd HH:mm:ss",readOnly = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
