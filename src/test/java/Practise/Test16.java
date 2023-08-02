package Practise;

import org.testng.annotations.Test;

import PojoClass.TYProject;
import RestGenericMethods.JavaLibrary;

public class Test16 {
	@Test
	public void ValidateGUI() {
		JavaLibrary jlib=new JavaLibrary();
		TYProject typ=new TYProject("OSA"+jlib,"krishna16"," on going", 12);
		
	}

}
