package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123";

		// Connection 객체를 얻어서 update 구문을 직접 만들어 보세요.

		// mydb2 사용 , employee 테이블에 값을 넣는 코드를 작성하세요

		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);

			String query = "update students set name=? where name =?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, "왕건");
			preparedStatement.setString(2, "이순신");

			int rowCount = preparedStatement.executeUpdate();
			System.out.println("updateRowCount:" + rowCount);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
