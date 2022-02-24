package com.qa.trcrm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	static Workbook book;
	static Sheet sheet;
	static Object data[][];

	public static Object[][] getData(String sheetName) {

		File f = new File("./src/main/java/com/qa/trcrm/testdata/TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(f);
			book = WorkbookFactory.create(fis);
			sheet = book.getSheet(sheetName);
			int row = sheet.getLastRowNum();
			 data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					//System.out.println(data[i][j]);
				}
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		

	}
	public static void main(String[] args) {
		getData("contacts2");
	}
}
