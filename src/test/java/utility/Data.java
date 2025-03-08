package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Data  {

	String filepath = "C:\\Users\\venka\\Downloads\\Book1.xlsx";
	ExcelUtilityfile excel = new ExcelUtilityfile(filepath);

	@DataProvider(name="dp")
	public String [][] data1() throws IOException {
		
		String[][] data1 = excel.getcelldata("Sheet1");
		
		return data1;
		
	}
}
