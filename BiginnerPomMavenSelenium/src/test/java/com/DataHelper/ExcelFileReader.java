package com.DataHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFileReader {
	
	
	
	public static Object[][] dataReader(String filePath, String sheetName) throws IOException{
	   
	    File file = new File(filePath);
	    
	    FileInputStream fis=new FileInputStream(file);
	    
		Workbook wb =  new XSSFWorkbook(fis);
	    Sheet ws = wb.getSheet(sheetName);
	    
	    int rowCount = ws.getLastRowNum()- ws.getFirstRowNum();
	    int colCount=ws.getRow(0).getLastCellNum();
	    Object[][]  object = new Object[rowCount][colCount];
	    for (int i = 0; i <rowCount; i++) {
	        
	        Row row = ws.getRow(i+1);
	        
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            
	            object[i][j] = row.getCell(j).toString();
	        }
	   }
	    	
	    	return object;    
    }
		
}
