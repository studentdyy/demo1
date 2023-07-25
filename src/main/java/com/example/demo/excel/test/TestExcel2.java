package com.example.demo.excel.test;

import com.example.demo.excel.ExcelUtils;
import com.example.demo.excel.pojo.ExcelBaoJinSheBei;
import com.example.demo.excel.pojo.ExcelTemplate;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.List;

/**
 * @author dyy
 * @version 0.1
 * @date 2023/7/25 11:08
 */
public class TestExcel2 {
    public static void main(String[] args) throws Exception {
        File inputfile1 = new File("src/main/resources/templates/excel/一键报警（离线）排查0725(3).xlsx");
        File inputfile2 = new File("src/main/resources/templates/excel/排查.xlsx");
        List<ExcelBaoJinSheBei> shebei = ExcelUtils.readFile(inputfile2, ExcelBaoJinSheBei.class);

        FileInputStream is = new FileInputStream(inputfile1);
        XSSFWorkbook workbook = new XSSFWorkbook(is);

        XSSFSheet sheet = workbook.getSheetAt(0);
        // 文件的总行数
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rowCount; i++) {
            // 解析每一行
            Row row = sheet.getRow(i);
            if (!isRowEmpty(row)) {
                Cell cell = row.getCell(13);
                if (cell != null){
                    String stringCellValue = cell.getStringCellValue();
                    if (stringCellValue!=null){
                        for (ExcelBaoJinSheBei excelBaoJinSheBei : shebei) {
                            if (stringCellValue.equals(excelBaoJinSheBei.getNumber())){
                                Cell cell1 = row.getCell(15);
                                cell1.setCellValue(excelBaoJinSheBei.getState());
                            }
                        }
                    }
                }
            }
        }
        OutputStream outputStream = new FileOutputStream("src/main/resources/templates/excel/排查结果.xlsx");
        workbook.write(outputStream);
    }

    /**
     * 判断excel某行是否为空
     * @param row
     * @return
     */
    public static boolean isRowEmpty(Row row) {
        if (null == row) {
            return true;
        }
        //第一个列位置
        int firstCellNum = row.getFirstCellNum();
        //最后一列位置
        int lastCellNum = row.getLastCellNum();
        //空列数量
        int nullCellNum = 0;
        for (int c = firstCellNum; c < lastCellNum; c++) {
            Cell cell = row.getCell(c);
            if (null == cell || CellType.BLANK == cell.getCellType()) {
                nullCellNum ++;
                continue;
            }
            cell.setCellType(CellType.STRING);
            String cellValue = cell.getStringCellValue().trim();
            if (StringUtils.isEmpty(cellValue)) {
                nullCellNum ++;
            }
        }
        return nullCellNum == (lastCellNum - firstCellNum);
    }
}
