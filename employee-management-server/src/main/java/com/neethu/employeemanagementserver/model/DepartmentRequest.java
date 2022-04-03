package com.neethu.employeemanagementserver.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DepartmentRequest {

	@NotNull
	private String code;
	
	@NotNull
	private String description;

}
