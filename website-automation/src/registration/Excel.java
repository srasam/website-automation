package registration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 
{
XSSFWorkbook workbook;
XSSFSheet sheet;
public Excel(String filepath) throws IOException
{
	FileInputStream fs;
	try {
		fs = new FileInputStream(filepath);
		workbook =new XSSFWorkbook(fs);
	} 
	catch (FileNotFoundException e) 
	{
		
		e.printStackTrace();
	}
	
}
public String getData(int sheetnumber,int row,int col)
{
	sheet=workbook.getSheetAt(sheetnumber);
	String data=sheet.getRow(row).getCell(col).getStringCellValue();
	return data;
}
public int getRowCount(int sheetindex)
{
	int rowcount=workbook.getSheetAt(sheetindex).getLastRowNum();
	rowcount=rowcount+1;
	return rowcount;
}

}
