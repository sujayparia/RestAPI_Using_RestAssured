package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getData {


	public static String testData(String testcase, String column) {
		
		String data=null;

		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\TestCase\\TestCases.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("TestCase");
			
			int finalRowIndex=0;
			int finalColumnIndex=0;
			
			for (int currentRow=1; currentRow<=sheet.getLastRowNum();currentRow++) {
				Row row = sheet.getRow(currentRow);
				Cell cell = row.getCell(1);
				String currentValue = cell.getStringCellValue();

				if (currentValue.equalsIgnoreCase(testcase)) {
					finalRowIndex = currentRow;
					break;
				}
			}
			
			Row firstRow = sheet.getRow(0);

			for (int currentCol=0; currentCol<=firstRow.getLastCellNum();currentCol++) {
				Cell columnName = firstRow.getCell(currentCol);
				String currentColValue = columnName.getStringCellValue();

				if (currentColValue.equalsIgnoreCase(column)) {
					finalColumnIndex = currentCol;
					break;
				}

			}
			
			data = sheet.getRow(finalRowIndex).getCell(finalColumnIndex).getStringCellValue();
			//System.out.println(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
}
