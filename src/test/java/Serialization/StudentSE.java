package Serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.Student;

public class StudentSE {

	@Test
	public void studentDetails() throws Throwable, JsonMappingException, IOException {
		long []phNo= {7502231338l,6369503104l};
		String []parents= {"sundar","kalai"};
		long []p_phNo= {1233659305l, 5349857647l};
		
		Student std=new Student("krishna","cse",29,phNo,parents);
		Student std1=new Student(null, null, 0, p_phNo, parents);
		ArrayList<Student> std23=new ArrayList<Student>();
		std23.add(std);
		std23.add(std1);
		ArrayList<Student> std24=new ArrayList<Student>();
		std24.addAll(std23);
		ObjectMapper map=new ObjectMapper();
		
		map.writeValue(new File("./data3.json"), std24);
	}
}
