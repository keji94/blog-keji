package com.keji.blog.controller.Excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

import static org.apache.poi.ss.usermodel.CellType.*;

/**
 * Created by wb-ny291824 on 2017/8/29.
 */
public class POIDemo {

    @Test
    public void demo() {
        //创建Workbook(Excel文档)
        HSSFWorkbook wb = new HSSFWorkbook();
        try {
            FileOutputStream fs = new FileOutputStream("d:\\workbook.xls");
            wb.write(fs);
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @throws IOException
     * 请注意，工作表名称不得超过31个字符.并且不得包含以下任何字符：
     * 0x0000、0x0003、冒号（:)、反斜杠（\）、星号（ *）、问号（？）、正斜杠（/）、开方括号（[）、关闭方括号（））
     *
     * 可以使用org.apache.poi.ss.util.WorkbookUtil＃createSafeSheetName （String nameProposal）。
     * 这个方法可以创建一个安全的sheet 名字，它会用空格' '代替不合法的字符
     */
    @Test
    public void createSheet() throws IOException {
        //创建sheet,如果名字有非法字符会报错。
        Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
        Sheet sheet1 = wb.createSheet("new sheet");
        Sheet sheet2 = wb.createSheet("second sheet");

        //使用WorkbookUtil创建sheet,会将非法字符替换成空格。
        String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "
        Sheet sheet3 = wb.createSheet(safeName);

        FileOutputStream fileOut = new FileOutputStream("d:\\workbook.xls");
        wb.write(fileOut);
        fileOut.close();
    }

    /**
     * 创建单元格
     * @throws Exception
     */
    @Test
    public void createCells() throws Exception {
        Workbook wb = new HSSFWorkbook();
        //Workbook wb = new XSSFWorkbook();

        Sheet sheet = wb.createSheet("new sheet");

        CreationHelper createHelper = wb.getCreationHelper();
        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow((short)0);
        // Create a cell and put a value in it.
        Cell cell = row.createCell(0);
        cell.setCellValue(1);

        // Or do it on one line.
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(
                createHelper.createRichTextString("This is a string"));  //不知道有什么用。
        row.createCell(3).setCellValue(true);
        row.createCell(4).setCellValue("String cvcvc cvcv cvc ?");

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("d:\\workbook.xls");
        wb.write(fileOut);
        fileOut.close();
    }

    /**
     * 创建日期单元格
     */
    @Test
    public void createDateCell() throws IOException {
//        Workbook wb = new HSSFWorkbook();
        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        // 新建一行，在行中增加几个单元格。行数从0开始
        Row row = sheet.createRow(0);

        // 创建一个单元格，放置一个Date类型的值.这个单元格不是Date格式
        Cell cell = row.createCell(0);
        cell.setCellValue(new Date());

        // 将这个单元格设置为日期格式.  It is important to
        // 创建一个带格式的心单元格是非常重要的，否则最终可以修改内置样式，这不仅会影响这一行，还会影响其他行
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        cell = row.createCell(1);
        cell.setCellValue(new Date());
        cell.setCellStyle(cellStyle);

        //使用 java.util.Calendar 设置时间
        cell = row.createCell(2);
        cell.setCellValue(Calendar.getInstance());
        cell.setCellStyle(cellStyle);

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("d:\\workbook.xls");
        wb.write(fileOut);
        fileOut.close();
    }

    /**
     * 创建不同风格的cell
     */
    @Test
    public void createDiffTypesOfCells() throws IOException {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");
        Row row = sheet.createRow((short)2);
        row.createCell(0).setCellValue(1.1);
        row.createCell(1).setCellValue(new Date());
        row.createCell(2).setCellValue(Calendar.getInstance());
        row.createCell(3).setCellValue("a string");
        row.createCell(4).setCellValue(true);
        row.createCell(5).setCellType(HSSFCell.CELL_TYPE_ERROR);

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("d:\\workbook.xls");
        wb.write(fileOut);
        fileOut.close();
    }

    /**
     * Files 和 InputStreams
     * 如果需要打开一个workbook,不管是.xls还是xlsx形式的，都可以使用File 或者InputStream.用File需要的内存会少
     * 一些，而InputStream耗费的内存大一些，因为后者需要缓存整个文件进内存。
     */

    public void fileVSinputStream() throws IOException, InvalidFormatException {
        //使用WorkbookFactory创建Workbook非常简单
        Workbook wb = WorkbookFactory.create(new File("MyExcel.xls"));
        Workbook wb1 = WorkbookFactory.create(new FileInputStream("MyExcel.xlsx"));

        //如果直接使用HSSFWorkbook or XSSFWorkbook,您通常应该通过NPOIFSFileSystem或 OPCPackage来完全控制生命周期
        // HSSFWorkbook, File
        NPOIFSFileSystem fs = new NPOIFSFileSystem(new File("file.xls"));
        HSSFWorkbook wb2 = new HSSFWorkbook(fs.getRoot(), true);
            //....do shomething
        fs.close();

        InputStream myInputStream = new FileInputStream("new File(d:\\workbook.xlsx)");

        // HSSFWorkbook, InputStream, 需要更多内存
        NPOIFSFileSystem fs5 = new NPOIFSFileSystem(myInputStream);
        HSSFWorkbook wb5 = new HSSFWorkbook(fs5.getRoot(), true);
        // XSSFWorkbook, File
        OPCPackage pkg = OPCPackage.open(new File("file.xlsx"));
        XSSFWorkbook wb3 = new XSSFWorkbook(pkg);
        //....do shomething
        pkg.close();

        // XSSFWorkbook, InputStream, needs more memory
        OPCPackage pkg2 = OPCPackage.open(myInputStream);
        XSSFWorkbook wb4 = new XSSFWorkbook(pkg);
        //....do shomething
        pkg.close();
    }

    /**
     * 设置单元格水平垂直对齐方式
     */
    @Test
    public  void demo3() throws Exception {
        Workbook wb = new XSSFWorkbook(); //or new HSSFWorkbook();

        Sheet sheet = wb.createSheet();
        Row row = sheet.createRow((short) 3); //在第4行，不是创建4行
        row.setHeightInPoints(30);

        createCell(wb, row, (short) 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_BOTTOM);
        createCell(wb, row, (short) 1, CellStyle.ALIGN_CENTER_SELECTION, CellStyle.VERTICAL_BOTTOM);
        createCell(wb, row, (short) 2, CellStyle.ALIGN_FILL, CellStyle.VERTICAL_CENTER);
        createCell(wb, row, (short) 3, CellStyle.ALIGN_GENERAL, CellStyle.VERTICAL_CENTER);
        createCell(wb, row, (short) 4, CellStyle.ALIGN_JUSTIFY, CellStyle.VERTICAL_JUSTIFY);
        createCell(wb, row, (short) 5, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_TOP);
        createCell(wb, row, (short) 6, CellStyle.ALIGN_RIGHT, CellStyle.VERTICAL_TOP);

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("d:\\xssf-align.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }

    /**
     * 创建一个单元格并以一定的方式对齐它。
     *
     * @param wb     the workbook
     * @param row    the row to create the cell in
     * @param column the column number to create the cell in
     * @param halign the horizontal alignment for the cell.
     */
    private static void createCell(Workbook wb, Row row, short column, short halign, short valign) {
        Cell cell = row.createCell(column);
        cell.setCellValue("Align It");
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cell.setCellStyle(cellStyle);
    }


    /**
     * 设置单元格边界
     */
    @Test
    public void setBorders() throws IOException {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(1);

        // Create a cell and put a value in it.
        Cell cell = row.createCell(1);
        cell.setCellValue(4);

        // Style the cell with borders all around.
        CellStyle style = wb.createCellStyle();
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLUE.getIndex());
        style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cell.setCellStyle(style);

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("d:\\workbook.xls");
        wb.write(fileOut);
        fileOut.close();
    }

    /**
     * 迭代行和单元格
     * 有时候，您可能想迭代工作簿中的所有工作表，工作表中的所有行或一行中的所有单元格。这是可能的一个简单的for循环。
     * 这些迭代器可通过调用workbook.sheetIterator（）， sheet.rowIterator（）和row.cellIterator（）或隐式使用for-each循环来获得。
     * 请注意，rowIterator和cellIterator会遍历已创建的行或单元格，跳过空行和单元格。
     *
     * 迭代单元行
     * 在某些情况下，当迭代时，您需要完全控制如何处理丢失或空白的行和单元格，您需要确保访问每个单元格，而不仅仅是访问该文件中定义的单元格。
     * （CellIterator将只返回在文件中定义的单元格，主要是具有值或样式的单元格，但取决于Excel）。
     在这些情况下，您应该获取行的第一列和最后一列信息，然后调用getCell（int，MissingCellPolicy） 来获取单元格。使用 MissingCellPolicy 来控制如何处理空白或空白单元格。
     */
    @Test
    public void iterateCell() throws IOException, InvalidFormatException {
        int MY_MINIMUM_COLUMN_COUNT = 0;
        Workbook workbook = WorkbookFactory.create(new File("d:\\user.xlsx"));
        Sheet sheet = workbook.getSheetAt(0);
        // Decide which rows to process
        int rowStart = Math.min(15, sheet.getFirstRowNum());
        int rowEnd = Math.max(1400, sheet.getLastRowNum());

        for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
            Row r = sheet.getRow(rowNum);
            if (r == null) {
                // This whole row is empty
                // Handle it as needed
                continue;
            }

            int lastColumn = Math.max(r.getLastCellNum(), MY_MINIMUM_COLUMN_COUNT);

            for (int cn = 0; cn < lastColumn; cn++) {
                Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
                if (c == null) {
                    // The spreadsheet is empty in this cell
                } else {
                    // Do something useful with the cell's contents
                    int i = c.getCellType();
                    System.out.println(c.getStringCellValue());
                }
            }
         }
    }

    /**
     * 要获得单元格的内容，你首先需要知道这个单元格的type(String Date等)，如果你要获得String类型的，但实际
     * 是日期就会抛异常
     */
    @Test
    public void getCellContent() throws IOException, InvalidFormatException {
        DataFormatter formatter = new DataFormatter();
        int MY_MINIMUM_COLUMN_COUNT = 0;
        Workbook wb = WorkbookFactory.create(new File("d:\\user.xlsx"));
        Sheet sheet1 = wb.getSheetAt(0);
        for (Row row : sheet1) {
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                System.out.print(cellRef.formatAsString());
                System.out.print(" - ");

                // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                String text = formatter.formatCellValue(cell);
                System.out.println(text);

                // Alternatively, get the value and format it yourself
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        System.out.println(cell.getRichStringCellValue().getString());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.println(cell.getDateCellValue());
                        } else {
                            System.out.println(cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        System.out.println(cell.getCellFormula());
                        break;
                    case BLANK:
                        System.out.println();
                        break;
                    default:
                        System.out.println();
                }
            }
        }
    }

    /**
     * 文本提取
     *大多数的文本提取需求，使用标准的ExcelExtractor接口可以满足需要。
     * XSSFExcelExtractor实现了这个接口
     */
    @Test
    public void textExtraction() throws IOException {
        InputStream inp = new FileInputStream("workbook.xls");
        HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));
//        ExcelExtractor extractor = new ExcelExtractor(wb);      //new 接口？？

//        extractor.setFormulasNotResults(true);
//        extractor.setIncludeSheetNames(false);
//        String text = extractor.getText();
    }

    /**
     * 填充和颜色
     */
    @Test
    public void fillAndColor() throws IOException {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow((short) 1);

        // Aqua background
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(CellStyle.BIG_SPOTS);
        Cell cell = row.createCell((short) 1);
        cell.setCellValue("X");
        cell.setCellStyle(style);

        // Orange "foreground", foreground being the fill foreground not the font color.
        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell = row.createCell((short) 2);
        cell.setCellValue("X");
        cell.setCellStyle(style);

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("workbook.xls");
        wb.write(fileOut);
        fileOut.close();
    }



}
