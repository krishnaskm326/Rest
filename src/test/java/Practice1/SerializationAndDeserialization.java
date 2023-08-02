package Practice1;

import org.testng.annotations.Test;

import PojoClass.ProjectEcomm;
import RestGenericMethods.JavaLib;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;

public class SerializationAndDeserialization {

	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
		JavaLib jlib=new JavaLib();
		ProjectEcomm pro=new ProjectEcomm("krishna","E-comm"+jlib.random(),"on going",4);
		ObjectMapper obj=new ObjectMapper();
		obj.writeValue(new File("./sample.json"), pro);
		
	}
	
	@Test
	public void deSerialization() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper obj=new ObjectMapper();
		ProjectEcomm pcom = obj.readValue(new File("./sample.json"), ProjectEcomm.class);
		System.out.println(pcom.getProjectName());
		System.out.println(pcom.getCreatedBy());
		System.out.println(pcom.getStatus());
		System.out.println(pcom.getTeamSize());
		System.out.println(pcom.getClass());
		
		
	}
}