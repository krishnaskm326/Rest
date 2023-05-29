package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.EmployeeArray;

public class EmployeeSEAy {

	@Test
	public void empPhNoArray() throws Throwable, JsonMappingException, IOException {
		long []phNo= {6369503104l,7502231338l};
		EmployeeArray eArray=new EmployeeArray("Krishna", phNo);
		ObjectMapper omap=new ObjectMapper();
		omap.writeValue(new File("./data1.json"), eArray);
	}
}
