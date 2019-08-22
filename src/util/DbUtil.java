package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	private static Connection connection = null;
	private static String url = "jdbc:postgresql://localhost:5432/todoapp";
	private static String username = "postgres";
	private static String password = "159852";
	
	public static Connection getConnection() {
		
		if(connection != null) 
			return connection;
		else
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url,username,password);
			}
			catch(SQLException | ClassNotFoundException e){
				e.printStackTrace();
			}
		return connection;
	}

}
