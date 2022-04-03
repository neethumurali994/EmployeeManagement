package com.neethu.employeemanagementserver.model;

import java.time.LocalDate;
import com.neethu.employeemanagementserver.entity.Department;
import lombok.Data;

@Data
public class EmployeeDTO {
	
	private Long id;

	private Long employeeNo;

	private String employeeName;

	private LocalDate dateOfJoin;

	private Department department;
	
	private Integer salary;
}
