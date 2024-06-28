package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLJdbcExample {

	public static void main(String[] args) {

		// 준비물

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root";// 상용서비스에서 절대 루트 계정 사용 금지
		String password = "asd123";

		// 필요 데이터 타입
		// JDBC API (자바 개시자들이 기념화 시키기 위한 문화)
		Connection connection = null;
		java.sql.Statement statement = null;
		ResultSet resultSet = null;

		// 1. MY SQL 구현체를 사용하겠다는 설정을 해야 한다.
		// JBDC드라이버 로드( MySQL)
		try {
			// 1. 메모리에 사용하는 드라이버(JDBC API 를 구현한 클래스)를 띄운다.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. 데이터 베이스 연결 설정

			connection = DriverManager.getConnection(url, user, password);

			// 3. SQL 실행 (PreparedStatement 객체 사용해보기)

			// 3-1 쿼리 만들어 보기
			String query = "insert into employee values(?,?,?,?,now())";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 7);
			preparedStatement.setString(2, "이순신");
			preparedStatement.setString(3, "IT");
			preparedStatement.setString(4, "5000000.00");
			
			// 실행에 호출은 executeQuery 사용
//			preparedStatement.executeQuery();
			// 4. 결과 처리
			
			int rowCount= preparedStatement.executeUpdate();
			System.out.println("rowCount:"+ rowCount);


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
