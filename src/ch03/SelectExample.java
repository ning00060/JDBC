package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExample {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			String query = "select * from employee";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println("resultSet:id: " + resultSet.getInt("id"));
				System.out.println("resultSet:name: " + resultSet.getString("name"));
				System.out.println("resultSet:department: " + resultSet.getString("department"));
				System.out.println("resultSet:salary: " + resultSet.getInt("salary"));
				System.out.println("resultSet:hire_date: " + resultSet.getString("hire_date"));
				System.out.println("-------------------------------");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
