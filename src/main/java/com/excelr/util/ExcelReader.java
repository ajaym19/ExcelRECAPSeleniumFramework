package com.excelr.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelReader(String filePath, String sheetName) {
		try {
			wb = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = wb.getSheet(sheetName);
	}

	public Object[][] getData() {
		//get the number of rows
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][colCount];
		for (int row = 0; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				data[row][col] = sheet.getRow(row).getCell(col);
			}
		}
		return data;
	}
}
