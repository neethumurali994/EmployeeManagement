package com.neethu.employeemanagementserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neethu.employeemanagementserver.entity.Department;
import com.neethu.employeemanagementserver.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	public List<Department> findAll() {
		List<Department> departments = departmentRepository.findAll();
		return departments;
	}
	
	public Department findById(Long id) {
		return departmentRepository.findById(id).get();
	}
	
	public Department insert(Department department) {
		return departmentRepository.save(department);
	}
	
	public void deleteById(Long id) {
		departmentRepository.deleteById(id);
	}
}

