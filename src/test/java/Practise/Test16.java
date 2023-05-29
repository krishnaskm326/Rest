package Practise;

import org.testng.annotations.Test;

import BDDGenericMethods.JavaLibrary;
import PojoClass.TYProject;

public class Test16 {
	@Test
	public void ValidateGUI() {
		JavaLibrary jlib=new JavaLibrary();
		TYProject typ=new TYProject("OSA"+jlib,"krishna16"," on going", 12);
		
	}

}
