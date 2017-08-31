package com.keji.blog.controller.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Created by wb-ny291824 on 2017/8/29.
 */
public class ExcelReaderTest {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\wb-ny291824\\Desktop\\员工表模板.xlsx");
        FileInputStream is = new FileInputStream(file);
        ExcelReader excelReader = new ExcelReader();
        String[] strings = excelReader.readExcelTitle(is);
        for (String string : strings) {
            System.out.println(string);
        }
        is.close();
        is = new FileInputStream(file);
        Map<Integer, String> map = excelReader.readExcelContent(is);
        for (int i = 1 ; i <=map.size() ; i++) {
            System.out.println(map.get(i));
        }
        is.close();
    }
}
