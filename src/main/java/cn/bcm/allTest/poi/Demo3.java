package cn.bcm.allTest.poi;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @ClassName Demo3
 * @Author beichunming
 * @Date 2018/11/19 下午3:06
 */
public class Demo3 {
    private final static File file = new File("/Users/beichunming/Desktop/AllFiles/poifiles/工作簿.xls");

    public static void main(String[] args) throws Exception{
        operaterExcel3();
    }

    public static void operaterExcel1() throws Exception{
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("first sheet");
        Row row = sheet.createRow(2);
        row.setHeightInPoints(30);

        createCell(wb,row,(short)0, HorizontalAlignment.CENTER,VerticalAlignment.CENTER);
        createCell(wb,row,(short)1, HorizontalAlignment.LEFT,VerticalAlignment.BOTTOM);
        createCell(wb,row,(short)2, HorizontalAlignment.FILL,VerticalAlignment.TOP);

        FileOutputStream fout  = new FileOutputStream(file);
        wb.write(fout);
        fout.close();
    }

    private static void createCell(Workbook wb, Row row, short colunm, HorizontalAlignment halign, VerticalAlignment valign){
        Cell cell = row.createCell(colunm);
        cell.setCellValue(new HSSFRichTextString("Align it"));
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cell.setCellStyle(cellStyle);
    }

    public static void operaterExcel2() throws Exception{

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("second sheet");
        Row row = sheet.createRow(1);
        Cell cell = row.createCell(1);
        cell.setCellValue(4);

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderBottom(BorderStyle.THIN); // 底部边框
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex()); // 底部边框颜色

        cellStyle.setBorderLeft(BorderStyle.THIN);  // 左边边框
        cellStyle.setLeftBorderColor(IndexedColors.GREEN.getIndex()); // 左边边框颜色

        cellStyle.setBorderRight(BorderStyle.THIN); // 右边边框
        cellStyle.setRightBorderColor(IndexedColors.BLUE.getIndex());  // 右边边框颜色

        cellStyle.setBorderTop(BorderStyle.MEDIUM_DASHED); // 上边边框
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());  // 上边边框颜色

        cell.setCellStyle(cellStyle);

        FileOutputStream fout  = new FileOutputStream(file);
        wb.write(fout);
        fout.close();
    }
    /**
     * @Author beichunming
     * @Description combine dnayuange
     * @Date 下午4:33 2018/11/19
     * @Param []
     * @return void
     **/
    public static void operaterExcel3() throws Exception{

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("third sheet");
        Row row = sheet.createRow(1);
        Cell cell = row.createCell(1);

        cell.setCellValue("dnayuange  test");
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cell.setCellStyle(cellStyle);
        sheet.addMergedRegion(new CellRangeAddress(
                1,
                2,
                1,
                2));

        FileOutputStream fout = new FileOutputStream(file);
        wb.write(fout);
        fout.close();
    }
}
