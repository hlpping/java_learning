package cn.test.itcast.poi;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class A {
	public static void main(String[] args) throws IOException {
		//创建一个xls文件
		HSSFWorkbook book =new HSSFWorkbook();
		//创建一个表
		HSSFSheet sheet = book.createSheet("第一个表");
		
		//创建第一行
		HSSFRow row =sheet.createRow(0);
		//在第一行中添加第一列  并添加元素
		HSSFCell cell =row.createCell(0);		
		cell.setCellValue("Hello world00");
		
		//在第一行中添加第二列 并添加元素
		cell =row.createCell(1);
		cell.setCellValue("Hello world01");
		
		//创建第二行,添加第一列  并添加元素
		row =sheet.createRow(1);
		cell =row.createCell(0);
		cell.setCellValue("Hello world10");
		//添加第二列  并添加元素
		cell =row.createCell(1);
		cell.setCellValue("Hello world11");
		
		//写出到文件
		book.write(new FileOutputStream("e:/xy.xls"));
		System.out.println("over");		
	}
}
/**需要jar 
 * jstl
 * standard
 * logging
 * poi	主要的包
 */
