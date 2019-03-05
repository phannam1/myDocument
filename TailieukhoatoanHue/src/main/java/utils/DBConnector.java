package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	Connection con = null;

	public DBConnector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydocument", "root", "123456");
			System.out.print("Connecting DB");
		} catch (Exception ex) {
			System.out.print("error connection");
		}
	}

	public Connection getCon() {
		return con;
	}
}
