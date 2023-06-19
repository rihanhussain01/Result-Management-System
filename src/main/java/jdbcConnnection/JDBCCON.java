package jdbcConnnection;

import java.sql.Connection;
import java.sql.DriverManager;

public final class JDBCCON {
	
	static Connection con = null;
	
	private JDBCCON() {
		
	}
	
	public static Connection getConnection() {
		
		
		if(con == null) {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo1" , "root" , "Rihan@123");
				return con;
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			return con;
		}
			
		
		
		
		
		return con;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
