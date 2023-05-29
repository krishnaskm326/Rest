package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.EmployeeComplex;
import PojoClass.EmployeeSpouse;

public class EmpSEComplex {

	@Test
	public void empComplex() throws Throwable, JsonMappingException, IOException {
		long []phNo= {6369503104l,7502231338l};
		EmployeeSpouse eSpouse=new EmployeeSpouse("soundhi",phNo);
		EmployeeComplex ecompl=new EmployeeComplex("krishna",eSpouse);
		ObjectMapper omap=new ObjectMapper();
	  omap.writeValue(new File("./data2.json"), ecompl);
	}
}
