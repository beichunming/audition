package cn.bcm.allTest.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @ClassName Demo1
 * @Author beichunming
 * @Date 2018/11/19 上午11:01
 */
public class Demo1 {

    public static void main(String[] args) throws Exception {

        createExcel3();
    }

    public static void createExcel1() throws Exception{
        Workbook workbook = new HSSFWorkbook();
        File file = new File("/Users/beichunming/Desktop/AllFiles/poifiles/用Poi搞出来的工作簿.xls");
        FileOutputStream fileout = new FileOutputStream(file);
        workbook.write(fileout);
        fileout.close();
    }

    public static void createExcel2() throws Exception{
        Workbook workbook = new HSSFWorkbook();
        workbook.createSheet("第一个sheet页");
        workbook.createSheet("第二个sheet页");
        File file = new File("/Users/beichunming/Desktop/AllFiles/poifiles/用Poi搞出来的工作簿.xls");
        FileOutputStream fileout = new FileOutputStream(file);
        workbook.write(fileout);
        fileout.close();
    }

    public static void createExcel3() throws Exception{
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("第一个sheet页");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(1);    //给单元格设置值
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue("this is a type of str");
        row.createCell(3).setCellValue(false);
        
        workbook.createSheet("第二个sheet页");
        File file = new File("/Users/beichunming/Desktop/AllFiles/poifiles/用Poi搞出来的工作簿.xls");
        FileOutputStream fileout = new FileOutputStream(file);
        workbook.write(fileout);
        fileout.close();
    }
}
