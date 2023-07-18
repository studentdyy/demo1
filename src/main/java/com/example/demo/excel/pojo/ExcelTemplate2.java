package com.example.demo.excel.pojo;

import com.example.demo.excel.ExcelExport;
import com.example.demo.excel.ExcelImport;
import lombok.Data;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/18 11:32
 */
@Data
public class ExcelTemplate2 {
    @ExcelImport("报警点编号1")
    private String BJDBH1;
    @ExcelImport("电话号码1")
    private String phone1;
    @ExcelImport("学校名称1")
    private String schoolName1;
    @ExcelImport("报警点编号2")
    private String BJDBH2;
    @ExcelImport("电话号码2")
    private String phone2;
    @ExcelImport("学校名称2")
    private String schoolName2;
}
