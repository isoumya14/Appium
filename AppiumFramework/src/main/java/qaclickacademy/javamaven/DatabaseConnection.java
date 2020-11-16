package qaclickacademy.javamaven;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class DatabaseConnection {
	
	@Test
	public void DBConnection() throws SQLException {
		
		String port ="3306";
		String host ="localhost";
		
	java.sql.Connection con = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "admin");
		
    java.sql.Statement st = con.createStatement();
   ResultSet rs =  st.executeQuery("select *from employeeinfo");
   
   while(rs.next()) {
   
   String id = rs.getString("id");
   String name =  rs.getString("name");
  
   System.out.println(id);
   System.out.println(name);
 
   }
	
	
	}

}
