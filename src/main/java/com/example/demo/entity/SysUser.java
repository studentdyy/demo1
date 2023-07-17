package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/17 15:56
 */
@Data
public class SysUser {
    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id")
    private Long userId;

    @ApiModelProperty(value = "姓名")
    private String fullName;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "密码（8位以上，字母+数字）")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "账号状态（0-正常，1-锁定）")
    private Integer isEnable;

    @ApiModelProperty(value = "是否删除    0：否，1：是")
    @JsonIgnore
    @TableLogic
    private Integer isDel;
}
