package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class utilities {
	public static String emailwithtimestamp() {
		Date date=new Date();
		String timestamp = date.toString().replace("", "_").replace(":", "_");
		return "amotoori"+timestamp+"@gmail.com";
	}
	
	public static Object[][] gettestdatafromexel(String sheetName) {
		File excelFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\Book 7.xlsx");
		XSSFWorkbook workbook=null;
		try {
		FileInputStream fisexel = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fisexel);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		  XSSFSheet sheet=workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][cols];
		for(int i=0;i<rows;i++)
		{
			XSSFRow row= sheet.getRow(i+1);
			for (int j=0;j<cols;j++)
			{
				XSSFCell cell=row.getCell(j);
				org.apache.poi.ss.usermodel.CellType cellType = cell.getCellType();
				
				switch(cellType) {
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]= Integer.toString ((int)cell.getNumericCellValue());			
					break;
				case BOOLEAN:
					data[i][j]= cell.getBooleanCellValue();
					break;
					}
				}
		}
		return data;

	}
	
}
