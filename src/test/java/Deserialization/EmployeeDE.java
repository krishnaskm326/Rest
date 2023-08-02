package Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.Employee;

public class EmployeeDE {

	@Test
	public void empDeSerial() throws Throwable, JsonMappingException, IOException {
		
		ObjectMapper map=new ObjectMapper();
		
		Employee data = map.readValue(new File("./data.json"), Employee.class);
		
		System.out.println(data.getEmp_Name());
		System.out.println(data.getEmp_Id());
		System.out.println(data.getEmp_Mail());
		System.out.println(data.getEmp_phone());
	}
}
