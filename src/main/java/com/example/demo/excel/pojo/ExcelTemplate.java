package com.example.demo.excel.pojo;

import com.example.demo.excel.ExcelExport;
import com.example.demo.excel.ExcelImport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/18 11:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelTemplate {
     /**
     * 原始数据
     */
    private String rowData;

    @ExcelExport("报警点编号")
    @ExcelImport("报警点编号")
    private String BJDBH;
    @ExcelExport("电话号码")
    @ExcelImport("电话号码")
    private String phone;
    @ExcelExport("学校名称")
    @ExcelImport("学校名称")
    private String schoolName;
}
