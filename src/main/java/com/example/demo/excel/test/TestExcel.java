package com.example.demo.excel.test;

import com.example.demo.excel.ExcelUtils;
import com.example.demo.excel.pojo.ExcelTemplate;
import com.example.demo.excel.pojo.ExcelTemplate2;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/18 11:14
 */
public class TestExcel {
    public static void main(String[] args) throws Exception{
        //根据文件位置找到需要读取的excel文件
        File Inputfile = new File("src/main/resources/templates/excel/test1.xlsx");
        File Inputfile2 = new File("src/main/resources/templates/excel/database2.xlsx");
        List<ExcelTemplate> ts1 = ExcelUtils.readFile(Inputfile, ExcelTemplate.class);
        List<ExcelTemplate> ts2 = ExcelUtils.readFile(Inputfile2, ExcelTemplate.class);


        List<ExcelTemplate2> result = new ArrayList<>();

        for (ExcelTemplate excelTemplate1 : ts1) {
            for (ExcelTemplate excelTemplate2 : ts2) {
                String bjdbh1 = excelTemplate1.getBJDBH();
                String bjdbh2 = excelTemplate2.getBJDBH();
                if (bjdbh1.equals(bjdbh2)){
                    String schoolName2 = excelTemplate2.getSchoolName();
                    String schoolName1 = excelTemplate1.getSchoolName();
                    if (schoolName1.equals(schoolName2)){
                        String phone2 = excelTemplate2.getPhone();
                        String phone1 = excelTemplate1.getPhone();
                        if (!phone2.equals(phone1)){
                            ExcelTemplate2 excelTemplateTemp = new ExcelTemplate2();
                            excelTemplateTemp.setBJDBH1(bjdbh1);
                            excelTemplateTemp.setBJDBH2(bjdbh2);
                            excelTemplateTemp.setPhone2(phone2);
                            excelTemplateTemp.setPhone1(phone1);
                            excelTemplateTemp.setSchoolName1(schoolName1);
                            excelTemplateTemp.setSchoolName2(schoolName2);
                            result.add(excelTemplateTemp);
                        }
                    }
                }
            }
        }
        ExcelUtils.exportFile("src/main/resources/templates","result",result);

    }
}
