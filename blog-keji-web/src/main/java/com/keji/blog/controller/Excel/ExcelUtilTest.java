package com.keji.blog.controller.Excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * Created by wb-ny291824 on 2017/8/29.
 */
public class ExcelUtilTest {
    public static void main(String[] args) throws IOException, InvalidFormatException {
//        Workbook workbook = ExcelUtil.getWorkbook(1, new FileInputStream(new File("C:\\Users\\wb-ny291824\\Desktop\\数据库表设计.xlsx")));
        OPCPackage pkg = OPCPackage.open(new File("C:\\Users\\wb-ny291824\\Desktop\\数据库表设计.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(pkg);
        ExcelUtil.getExcelString(workbook,0,0,0);
    }
}
