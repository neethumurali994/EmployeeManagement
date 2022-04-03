package com.neethu.employeemanagementserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neethu.employeemanagementserver.mapper.DepartmentMapper;
import com.neethu.employeemanagementserver.mapper.EmployeeMapper;
import com.neethu.employeemanagementserver.model.DepartmentDTO;
import com.neethu.employeemanagementserver.model.DepartmentRequest;
import com.neethu.employeemanagementserver.model.DepartmentResponse;
import com.neethu.employeemanagementserver.model.EmployeeDTO;
import com.neethu.employeemanagementserver.model.EmployeeRequest;
import com.neethu.employeemanagementserver.model.EmployeeResponse;
import com.neethu.employeemanagementserver.service.DepartmentOrchestrator;
import com.neethu.employeemanagementserver.service.EmployeeOrchestrator;

@RestController
@RequestMapping(path = "department")
public class DepartmentController {

	@Autowired
	DepartmentOrchestrator departmentOrchestrator;
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@GetMapping("/")
	public ResponseEntity<List<DepartmentResponse>> findAll() {
		List<DepartmentDTO> departmentDTOs = departmentOrchestrator.findAll();
		
		List<DepartmentResponse> departmentResponses = departmentMapper.mapToDepartmentResponses(departmentDTOs);

		return ResponseEntity.ok(departmentResponses);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DepartmentResponse> findById(@PathVariable("id") Long id) {
		DepartmentDTO departmentDTO = departmentOrchestrator.findById(id);

		DepartmentResponse departmentResponse = departmentMapper.mapToDepartmentResponse(departmentDTO);
		
		return ResponseEntity.ok(departmentResponse);
	}

	@PostMapping
	public ResponseEntity<DepartmentResponse> insert(@RequestBody DepartmentRequest departmentRequest) {
		DepartmentDTO departmentDTO = departmentMapper.mapToDepartmentDTO(departmentRequest);
		
		DepartmentDTO newDepartmentDTO = departmentOrchestrator.insert(departmentDTO);
		DepartmentResponse departmentResponse = departmentMapper.mapToDepartmentResponse(newDepartmentDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(departmentResponse);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DepartmentResponse> updateById(@PathVariable("id") Long id, @RequestBody DepartmentRequest departmentRequest) {
		DepartmentDTO departmentDTO = departmentMapper.mapToDepartmentDTO(departmentRequest);

		DepartmentDTO updatedDepartmentDTO = departmentOrchestrator.updateById(id, departmentDTO);

		DepartmentResponse departmentResponse = departmentMapper.mapToDepartmentResponse(updatedDepartmentDTO);
		
		return ResponseEntity.ok(departmentResponse);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		departmentOrchestrator.deleteById(id);
	}
}
