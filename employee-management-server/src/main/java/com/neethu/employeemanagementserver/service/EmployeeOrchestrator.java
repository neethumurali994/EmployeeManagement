package com.neethu.employeemanagementserver.service;

import java.util.List;
import com.neethu.employeemanagementserver.entity.Department;
import com.neethu.employeemanagementserver.entity.Employee;
import com.neethu.employeemanagementserver.mapper.DepartmentMapper;
import com.neethu.employeemanagementserver.mapper.EmployeeMapper;
import com.neethu.employeemanagementserver.model.DepartmentDTO;
import com.neethu.employeemanagementserver.model.EmployeeDTO;
import com.neethu.employeemanagementserver.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeOrchestrator {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	DepartmentService departmentService;
	
	public List<EmployeeDTO> findAll() {
		List<Employee> employees = employeeService.findAll();
		
		List<EmployeeDTO> employeeDTOs = employeeMapper.mapToEmployeeDTOs(employees);
		
		return employeeDTOs;
	}

	public EmployeeDTO findById(Long id) {
        Employee employee = employeeService.findById(id);
		
		EmployeeDTO employeeDTO = employeeMapper.mapToEmployeeDTO(employee);
		
		return employeeDTO;
	}
	
	public List<EmployeeDTO> searchByEmployeeName(String name) {
		List<Employee> employees = employeeService.searchByName(name);
		
		List<EmployeeDTO> employeeDTOs = employeeMapper.mapToEmployeeDTOs(employees);

		return employeeDTOs;
	}
	
	public EmployeeDTO insert(EmployeeDTO employeeDTO) {
		Employee employee = employeeMapper.mapToEmployee(employeeDTO, new Employee());
		Department department = departmentService.findById(employeeDTO.getDepartment().getId());
		employee.setDepartment(department);
		
		Employee newEmployee = employeeService.insert(employee);
		
		EmployeeDTO newEmployeeDTO = employeeMapper.mapToEmployeeDTO(newEmployee);
		return newEmployeeDTO;
	}
	
	
	public EmployeeDTO updateById(Long id, EmployeeDTO employeeDTO) {
		Employee employee = employeeService.findById(id);
		employeeMapper.mapToEmployee(employeeDTO, employee);
		Department department = departmentService.findById(employeeDTO.getDepartment().getId());
		employee.setDepartment(department);
		
		Employee updatedEmployee = employeeService.update(employee);
		
		EmployeeDTO updatedEmployeeDTO = employeeMapper.mapToEmployeeDTO(updatedEmployee);
		return updatedEmployeeDTO;
	}
	
	public void deleteById(Long id) {
		employeeService.deleteById(id);
	}
}
