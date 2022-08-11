package starter.Utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.serenitybdd.core.pages.PageObject;

public class ReadDataFromExcel extends PageObject {
	
	public String getData(String sheetName, String dataValue, String columnName) throws IOException {
		String actualValue = null;
		FileInputStream fs = new FileInputStream("C:\\Users\\KSANANTH\\Desktop\\nss-qa-ui-testing-serenity-BDD\\src\\test\\resources\\TestData\\Test_Data.xlsx");
		//Creating a workbook
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowTotal = sheet.getPhysicalNumberOfRows();
		System.out.println("Row number is: "+rowTotal);
		for(int i=0;i<rowTotal;i++) {
		String data = sheet.getRow(i).getCell(0).getStringCellValue();
		System.out.println("The row data value is: "+data);
		if(data.equals(dataValue)) {
			for(int j=0;j<=30;j++) {
				
				String columnData = sheet.getRow(0).getCell(j).getStringCellValue();
				System.out.println("The column data value is: "+columnData);
				if(columnData.equals(columnName)) {
					actualValue = sheet.getRow(i).getCell(j).getStringCellValue();
					break;
				}
			}
		}
		
		
		}
		
		return actualValue;
	}
	
}