package RestGenericMethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DataBaseUtility {
	Connection con;


	public void connectDB() throws Throwable {
		Driver drive=new Driver();
		DriverManager.registerDriver(drive);
		con=DriverManager.getConnection(IConstants.DBurl,IConstants.DBuser,IConstants.DBpwd);
	}
	

	public String executeAndGetData(String query,int cell,String eData) throws Throwable {
		ResultSet result=con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			if(result.getString(cell).equalsIgnoreCase(eData)){
				flag=true;
				break;
			}
		}
			if(flag)
			{
				System.out.println("verified");
				return eData;
			}
			else
			{
				System.out.println("data not verified");
				return "";
			
			
		}
		
	}
	public void closeDB() throws Throwable {
		con.close();
	}
		
		
	
}
