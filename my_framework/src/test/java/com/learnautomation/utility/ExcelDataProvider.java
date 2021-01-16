package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	XSSFWorkbook wb;
	public ExcelDataProvider() // e.g of how Constructor can be used n framework
	{
		File src = new File("./TestData/Data.xlsx");
		
			try {
				FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
			} 
			catch (Exception e) 
			{
				System.out.println("Unable to find Exce sheet" + e.getMessage());
			} 	
	}
	public String getStringData(int sheetIndex, int rowNum, int colNum)
	{
		 return wb.getSheetAt(sheetIndex).getRow(rowNum).getCell(colNum).getStringCellValue();
	}
	public String getStringData(String sheetName, int rowNum, int colNum)//e.g of Method Overloading i.e. this & the previous method
	{
		 return wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
	}
	public double getNumericData(String sheetName, int rowNum, int colNum)
	{
		return wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue();
	}
	
}
