package Serialization;

import java.io.File;
import java.io.IOException;


import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.Employee;

public class EmployeeSE {
        @Test
	public void employeeSeri() throws Throwable, JsonMappingException, IOException {
        	
		Employee emp=new Employee("krishna","TY40","krishnaskm326@gmail.com", 6369503104l);
		
		ObjectMapper map=new ObjectMapper();
		
		map.writeValue(new File("./data.json"), emp);
	}
}
