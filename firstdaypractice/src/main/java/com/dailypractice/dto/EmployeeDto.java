package com.dailypractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private long empId;
	private String name;
	private String emailId;
	private Integer age;
	private Double salary;
	private String department;
	private long mobileNumber;

}
