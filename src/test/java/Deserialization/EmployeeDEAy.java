package Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.EmployeeArray;
@Test
public class EmployeeDEAy {
public void empArray() throws Throwable, JsonMappingException, IOException {
	ObjectMapper omap=new ObjectMapper();
	EmployeeArray data = omap.readValue(new File("./data1.json"), EmployeeArray.class);
	System.out.println(data.getEmp_Name());
	System.out.println(data.getPhNo()[1]);
	System.out.println(data.getPhNo()[0]);
	
}
}
