package CarGallery.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB {// here we have connection to DB class 
	private static String driver = "com.mysql.jdbc.Driver"; 
	
	private static String url = "jdbc:mysql://localhost:3306/cgms";
	private static String user = "root";
	private static String pass = "";

	
	static{
		try {
			Class.forName(driver);
	
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
	}
	
	
	
	public static Connection getConnection() { // this function we use in every class that we need to connect DB

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection Succesful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Connection failed");
		}

		return conn;
	}
	
	

}
