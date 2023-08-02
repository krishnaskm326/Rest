package RestGenericMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {


	public Object[][] ReadSetOfData(String SheetName) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/restData/Excel.csv");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow=sh.getLastRowNum()+1;
		int lastCell=sh.getRow(0).getLastCellNum();
		Row a = sh.getRow(lastCell);
		  Cell c = a.getCell(lastCell);
		Object[][] obj=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
		
	}
}
