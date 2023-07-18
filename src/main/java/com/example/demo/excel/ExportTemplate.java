package com.example.demo.excel;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author dyy
 * @version 0.1
 * @date 2022/9/5 8:40
 */
@Data
public class ExportTemplate {
    @ExcelExport("导入结果")
    private String importResult;
    @ExcelExport("姓名")
    private String name;
    @ExcelExport("身份证")
    private String idCard;
    @ExcelExport("性别")
    private String gender;
    @ExcelExport("电话")
    private String phone;

    @ExcelExport("入党日期")
    private LocalDate joinPartyDate;

    @ExcelExport("出生日期")
    private LocalDate birthDate;

    @ExcelExport(value = "是否困难党员",kv = "0-否;1-是")
    private Integer isDifficultyNumbers;
}
