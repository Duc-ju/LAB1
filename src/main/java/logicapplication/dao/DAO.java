package logicapplication.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	protected Connection connection;

	public DAO() {
		String jdbcURL = "jdbc:mysql://localhost:3306/bookstore?useSSL=false";
		String jdbcUsername = "root";
		String jdbcPassword = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			System.out.println("Connection to database failed");
		}
	}
	public static void main(String[] args) {
		DAO dao = new DAO();
	}
}

