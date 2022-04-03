package com.neethu.employeemanagementserver.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false, length = 10)
	private Long employeeNo;
	
	@Column(nullable = false, length = 100)
	private String employeeName;
	
	@Column(nullable = false)
	private LocalDate dateOfJoin;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Department department;
	
	@Column(nullable = false, length = 10)
	private Integer salary;

}
