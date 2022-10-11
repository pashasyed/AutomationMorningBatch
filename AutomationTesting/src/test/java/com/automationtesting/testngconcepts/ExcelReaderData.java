package com.automationtesting.testngconcepts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReaderData {

	@Test
	public void countOfRowsCells() throws IOException {

		FileInputStream fi = new FileInputStream("C:\\Users\\gurum\\Desktop\\TestData.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fi);

		XSSFSheet sh = wb.getSheet("LoginData");

		int rowcount = sh.getLastRowNum();

		short cellvalue = sh.getRow(1).getLastCellNum();

		System.out.println("Row Count  is " + rowcount);
		System.out.println("Column count is " + cellvalue);

	}

	@Test
	public void readExcelData() throws IOException {

		FileInputStream fi = new FileInputStream("C:\\Users\\gurum\\Desktop\\TestData.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fi);

		XSSFSheet sh = wb.getSheet("LoginData");

		String usrname = sh.getRow(2).getCell(0).getStringCellValue();

		String password = sh.getRow(2).getCell(1).getStringCellValue();
		
		System.out.println("UserName is ::"+usrname);
		
		System.out.println("Password is ::"+password);

	}
}
