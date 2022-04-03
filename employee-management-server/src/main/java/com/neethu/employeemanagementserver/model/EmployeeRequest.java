package com.neethu.employeemanagementserver.model;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EmployeeRequest {

	@NotNull
	private Long employeeNo;

	@NotNull
	private String employeeName;
	
	@NotNull
	private LocalDate dateOfJoin;

	@NotNull
	private Long departmentId;
	
	@NotNull
	private Integer salary;
}
