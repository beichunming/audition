package cn.bcm.allTest.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName Demo2
 * @Author beichunming
 * @Date 2018/11/19 下午12:10
 */
public class Demo2 {

    private final static File file = new File("/Users/beichunming/Desktop/AllFiles/poifiles/工作簿.xls");
    private final static File file2 = new File("/Users/beichunming/Desktop/AllFiles/poifiles/二货.xls");

    public static void main(String[] args) throws  Exception{
        operaterExcel2();
    }

    public static void operaterExcel1() throws Exception{

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("first sheet");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(new Date());

        CreationHelper creationHelper = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();//单元格样式类
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd hh:mm:ss"));
        Cell cell2 =row.createCell(1);
        cell2.setCellValue(new Date());
        cell2.setCellStyle(cellStyle);

        Cell cell3 = row.createCell(2);
        cell3.setCellValue(Calendar.getInstance());
        cell3.setCellStyle(cellStyle);
        

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        wb.write(fileOutputStream);
        fileOutputStream.close();
    }

    public static void operaterExcel2() throws Exception{

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("first sheet");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(new Date());
        CreationHelper creationHelper = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();//单元格样式类
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd hh:mm:ss"));
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(0,9999);

        row.createCell(1).setCellValue(1);
        row.createCell(2).setCellValue("一个字符串");
        row.createCell(3).setCellValue(true);
        row.createCell(4).setCellValue(CellType.NUMERIC.getCode());
        row.createCell(5).setCellValue(false);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        wb.write(fileOutputStream);
        fileOutputStream.close();
    }

    public static void operaterExcel3() throws Exception{

        InputStream inputStream = new FileInputStream(file2);
       // POIFSFileSystem fs = new POIFSFileSystem(inputStream);
        XSSFWorkbook hwb = new XSSFWorkbook(inputStream);
        XSSFSheet xssfSheet = hwb.getSheetAt(0);
        if (xssfSheet ==null){
            return;
        }
        //Traversing row
        for (int rowNum = 0;rowNum<=xssfSheet.getLastRowNum();rowNum++){
            XSSFRow xssfRow = xssfSheet.getRow(rowNum);
            if (xssfRow == null){
                continue;
            }
            //Traversing cell
            for (int cellNum = 0;cellNum<xssfRow.getLastCellNum();cellNum++){
                XSSFCell xssfCell = xssfRow.getCell(cellNum);
                if (xssfCell == null){
                    continue;
                }
                System.out.print(" "+getValue(xssfCell));
            }
            System.out.println();
        }
    }

    public static String getValue(XSSFCell xssfCell){
        if (xssfCell.getCellTypeEnum() == CellType.NUMERIC){
            return String.valueOf(xssfCell.getNumericCellValue());
        }else if (xssfCell.getCellTypeEnum() == CellType.BOOLEAN){
            return String.valueOf(xssfCell.getBooleanCellValue());
        }
        return String.valueOf(xssfCell.getStringCellValue());
    }

    public static void operaterExcel4() throws Exception{

        InputStream inputStream = new FileInputStream(file2);
//        POIFSFileSystem fs=new POIFSFileSystem(inputStream);
//        HSSFWorkbook wb=new HSSFWorkbook(fs);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
        XSSFExcelExtractor excelExtractor = new XSSFExcelExtractor(xssfWorkbook);
        excelExtractor.setIncludeSheetNames(false);
        System.out.println(excelExtractor.getText());
    }
}
