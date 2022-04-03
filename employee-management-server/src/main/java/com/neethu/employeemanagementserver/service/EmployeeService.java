package com.neethu.employeemanagementserver.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.neethu.employeemanagementserver.entity.Department;
import com.neethu.employeemanagementserver.entity.Employee;
import com.neethu.employeemanagementserver.mapper.EmployeeMapper;
import com.neethu.employeemanagementserver.model.EmployeeDTO;
import com.neethu.employeemanagementserver.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	DepartmentService departmentService;
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
	}
	
	public Employee insert(Employee employee) {	
		return employeeRepository.save(employee);
	}
	
	public List<Employee> searchByName(String name) {
		Pageable pageable = PageRequest.of(0, 100);

		List<Employee> employees = employeeRepository.searchByEmployeeName(name, pageable);

		return employees;
	}
	
	public Employee update(Employee employee) {
		Employee newEmployee = employeeRepository.save(employee);

		return newEmployee;
	}
	
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}
}
