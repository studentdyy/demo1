package com.example.demo.excel.pojo;

import com.example.demo.excel.ExcelExport;
import com.example.demo.excel.ExcelImport;
import lombok.Data;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/25 11:11
 */
@Data
public class ExcelBaoJinSheBei {
    @ExcelImport("设备编号")
    @ExcelExport("设备编号")
    private String number;
    @ExcelImport("状态")
    @ExcelExport("状态")
    private String state;
}
