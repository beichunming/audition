package cn.bcm.allTest.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @ClassName Demo4
 * @Author beichunming
 * @Date 2018/11/19 下午4:33
 */
public class Demo4 {

    private final static File file = new File("/Users/beichunming/Desktop/AllFiles/poifiles/工作簿.xls");

    public static void main(String[] args) throws Exception {
        operaterExcel3();
    }

    public static void operaterExcel1() throws Exception{

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("first sheet");
        Row row = sheet.createRow(1);

        Font font = wb.createFont();
        font.setFontHeightInPoints((short)24);
        font.setFontName("Courier New");
        font.setItalic(true);
        font.setStrikeout(true);

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFont(font);

        Cell cell=row.createCell((short)1);
        cell.setCellValue("This is test of fonts");
        cell.setCellStyle(cellStyle);

        FileOutputStream fout  = new FileOutputStream(file);
        wb.write(fout);
        fout.close();
    }

    public static void operaterExcel2() throws Exception{

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("first sheet");
        Row row = sheet.createRow(1);
        Cell cell=row.createCell((short)1);
        cell.setCellValue("我要换行 \n 成功了吗？");

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setWrapText(true);
        cell.setCellStyle(cellStyle);

        // 调整下行的高度
        row.setHeightInPoints(2*sheet.getDefaultRowHeightInPoints());
        // 调整单元格宽度
        sheet.autoSizeColumn(2);

        FileOutputStream fout  = new FileOutputStream(file);
        wb.write(fout);
        fout.close();
    }

    public static void operaterExcel3() throws Exception{

        Workbook wb=new HSSFWorkbook(); // 定义一个新的工作簿
        Sheet sheet=wb.createSheet("第一个Sheet页");  // 创建第一个Sheet页
        CellStyle style;
        DataFormat format=wb.createDataFormat();
        Row row;
        Cell cell;
        short rowNum=0;
        short colNum=0;

        row=sheet.createRow(rowNum++);
        cell=row.createCell(colNum);
        cell.setCellValue(111111.25);

        style=wb.createCellStyle();
        style.setDataFormat(format.getFormat("0.0"));
        cell.setCellStyle(style);

        row=sheet.createRow(rowNum++);
        cell=row.createCell(colNum);
        cell.setCellValue(1111111.25);
        style=wb.createCellStyle();
        style.setDataFormat(format.getFormat("#,##0.000"));
        cell.setCellStyle(style);

        FileOutputStream fout  = new FileOutputStream(file);
        wb.write(fout);
        fout.close();
    }
}
