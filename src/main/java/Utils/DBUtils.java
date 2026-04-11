package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtils {
	private static Connection connection;
	
	public static Connection connect() {
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","password");
		}catch(Exception e) {
			throw new RuntimeException("DB Connection failed");
		}
		return connection;
	}
	
	public static ResultSet executeQuery(String query) {
		try {
			Statement stmt=connect().createStatement();
			return stmt.executeQuery(query);
		}catch(Exception e) {
			throw new RuntimeException("Query Execution is failed");
		}
	}
}
