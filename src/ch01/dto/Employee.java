package ch01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

	int emp_no;
	String dept_no;
	String from_date;
	String to_date;
	String salary;
	int No;

}
