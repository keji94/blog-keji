package com.keji.blog.controller.Excel;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Created by wb-ny291824 on 2017/8/29.
 * 操作Excel表格的功能类
 */
public class ExcelReader {
    private static DecimalFormat df = new DecimalFormat("0");
    private final static Logger log = Logger.getLogger(ExcelReader.class);
    private Workbook wb=null;
    private Sheet sheet=null;
    private Row row=null;

    /**
     * 读取Excel表格表头的内容
     * @param is
     * @return String 表头内容的数组
     * @throws IOException
     */
    public String[] readExcelTitle(InputStream is) throws Exception {
        try {
            wb = WorkbookFactory.create(is);
        } catch (IOException e) {
            log.error("读取Excel表格表头的内容异常", e);
            throw e;
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            title[i] = getCellFormatValue(row.getCell(i));
        }
        log.info("读取Excel表格表头的内容完毕");
        return title;
    }

    /**
     * 读取Excel数据内容
     * @param is
     * @return Map 包含单元格数据内容的Map对象
     * @throws IOException
     */
    public Map<Integer, String> readExcelContent(InputStream is) throws Exception {
        Map<Integer, String> content = new LinkedHashMap<Integer, String>();
        String str = "";
        try {
            wb = WorkbookFactory.create(is);
        } catch (IOException e) {
            log.error("读取Excel数据内容", e);
            throw e;
        }
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            while (j < colNum) {
                // 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
                // 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
                // str += getStringCellValue(row.getCell((short) j)).trim() +
                // "-";
                if (row != null) {
                    str += getCellFormatValue(row.getCell(j)).trim() + ",";
                } else {
                    str += "" + ",";
                }
                j++;
            }
            content.put(i, str.substring(0, str.length() - 1));
            str = "";
        }
        log.info("读取Excel数据内容完毕");
        return content;
    }

    /**
     * 根据Cell类型设置数据
     * @param cell
     * @return
     */
    private String getCellFormatValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case Cell.CELL_TYPE_NUMERIC:
                case Cell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (DateUtil.isCellDateFormatted(cell)) {
                        // 如果是Date类型则，转化为Data格式

                        //方法1：这样子的data格式是带时分秒的：2015-12-18 0:00:00
                        //cellvalue = cell.getDateCellValue().toLocaleString();

                        //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);

                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        cellvalue = String.valueOf(df.format(cell.getNumericCellValue()));
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case Cell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }
}
