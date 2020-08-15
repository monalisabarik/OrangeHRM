package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
  static Sheet sheet;
  
  public static void initilizeExcel() {
	  Workbook wbook=null;
	  String filePath= "E:\\practiceForInterview\\CodeBase\\OrangeHRM_Interview\\OrangeHRM_Interview\\src\\test\\resources\\TestData\\OrangeHRMTest.xlsx";
	  File file=new File(filePath);
	  try {
			FileInputStream fis = new FileInputStream(file);

			if (filePath.endsWith(".xlsx")) {
				wbook = new XSSFWorkbook(fis);
			} else if (filePath.endsWith(".xls")) {
				wbook = new HSSFWorkbook();
			} else {
				System.out.println("Invalid file format");
			}
		}catch(IOException e) {
			//Log.error("Failed to read the excel file"+e.getCause());
		}
		

		sheet = wbook.getSheet("TestData");
	}

	public static String readData(int row, int col)  {

		String value = sheet. getRow(row).getCell(col).getStringCellValue();
		return value;
	}
  public static int rowcount() {
  	return sheet.getLastRowNum();
  }
  public static int colcount() {
  	int lastrownum=rowcount();
  	Row r = sheet.getRow(lastrownum);
  	int maxCell=  r.getLastCellNum();
  	return maxCell;
  }
}
