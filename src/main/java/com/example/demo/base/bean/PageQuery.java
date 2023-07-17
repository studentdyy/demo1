package com.example.demo.base.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/17 10:02
 */
@Getter
@Setter
public class PageQuery {
    @ApiModelProperty("页数")
    private Long page;
    @ApiModelProperty("每页数量")
    private Long size;

    public Long getPage() {
        return page==null || page==0 ? 1 : page;
    }

    public Long getSize() {
        return size==null || size==0 ? 10 : size;
    }
}
