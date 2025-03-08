package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityfile {

	FileInputStream fileinput;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public String filepath;
	
	public ExcelUtilityfile(String filepath){
		this.filepath= filepath;
	}
	
	public String[][] getcelldata(String sheetname) throws IOException {
		
		fileinput= new FileInputStream(filepath);
		String data="";
		
		workbook= new XSSFWorkbook(fileinput);
		sheet= workbook.getSheet(sheetname);
		int coutrow = sheet.getLastRowNum();
		row= sheet.getRow(coutrow);
		int cellcount= row.getLastCellNum();
		
		String[][] data1 =new String[coutrow][cellcount];
		for (int i=1;i<=coutrow;i++) {
			row=sheet.getRow(i);
			for (int j=0;j<cellcount;j++) {
				
				data1[i-1][j]= row.getCell(j).getStringCellValue();
			}
		}
		
		return data1;
		
	}
	public static void main(String[] args) throws IOException {
	
		ExcelUtilityfile ee= new ExcelUtilityfile("C:\\Users\\venka\\Downloads\\Book1.xlsx");
		Object a1 =ee.getcelldata("sheet1");
		
		
	}
}
