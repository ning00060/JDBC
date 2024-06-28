package ch01.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// DTO 설계 하고
// 값을 담아서 . 연산자를 사용해 보시오.

public class SqlEmployee {
	Employee employee;

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/employees?serverTimezone=Asia/Seoul";
		String user = "root";// 상용서비스에서 절대 루트 계정 사용 금지
		String password = "asd123";

		Connection connection;
		Statement statement;
		ResultSet resultSet;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select *,row_number() over(order by salary asc) as No\r\n"
					+ "from dept_emp as d\r\n" + "join salaries as s\r\n" + "on d.emp_no=s.emp_no\r\n"
					+ "where s.salary>=70000 and d.emp_no between 20000 and 40000\r\n" + "order by salary asc;");

//			System.out.println("[");
			List<Employee> Employees = new ArrayList<>();
			while (resultSet.next()) {
//				System.out.println("{");
				System.out.println("employee EMP_NO : " + resultSet.getInt("emp_no") + ",");
				System.out.println("employee DEPT_NO : " + resultSet.getString("dept_no") + ",");
				System.out.println("employee FROM_DATE : " + resultSet.getString("from_date") + ",");
				System.out.println("employee TO_DATE : " + resultSet.getString("to_date") + ",");
				System.out.println("employee SALARY : " + resultSet.getInt("salary") + ",");
				System.out.println("employee No : " + resultSet.getInt("No") + ",");
				System.out.println("}");

			}

//			System.out.println("]");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
