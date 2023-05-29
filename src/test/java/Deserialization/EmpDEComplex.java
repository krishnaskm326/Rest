package Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.EmployeeComplex;

public class EmpDEComplex {

	@Test
	public void empComplex() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper omap=new ObjectMapper();
		EmployeeComplex data = omap.readValue(new File("./data2.json"), EmployeeComplex.class);
		System.out.println(data.getEmp_Name());
		System.out.println(data.getSpouse().getSpouse_Name());
		System.out.println(data.getSpouse().getPhNo()[1]);
		System.out.println(data.getSpouse().getPhNo()[0]);
	}
}
