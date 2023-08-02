package Validation;

import static io.restassured.RestAssured.when;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RakutenAPIvalidation {

	@Test

	public void dynamicResponseValidation() throws Throwable {
		Response resp = when().get("https://api.publicapis.org/entries");

		FileInputStream fis=new FileInputStream("./src/test/resources/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("API15");
		try
		{
			for(int i=1;i<10;i++) {
				String actData = resp.jsonPath().get("entries["+i+"].API");
				String act1Data = resp.jsonPath().get("entries["+i+"].Description");
				sh.createRow(0).createCell(0).setCellValue("API");
				sh.getRow(0).createCell(1).setCellValue("Description");
				sh.createRow(i).createCell(0).setCellValue(actData);
				sh.getRow(i).createCell(1).setCellValue(act1Data);
			}

			FileOutputStream fos=new FileOutputStream("./src/test/resources/Book2.xlsx");
			wb.write(fos);			
			wb.close();
		}


		catch (Exception e) {
			System.out.println(e);
		}

	}
}
