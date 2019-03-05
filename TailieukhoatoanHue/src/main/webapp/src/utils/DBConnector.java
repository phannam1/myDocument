package utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnector {
	Connection con = null;
	public DBConnector() {
		try {
			System.out.print("Connecting DB1..");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("Connecting DB2..");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydocument", "root","123456");
			System.out.print("Connecting DB3..");	
		}catch(Exception ex) {
			System.out.print("error connection");
		}	 
	}
	public Connection getCon() {
		return con;
	}
}
