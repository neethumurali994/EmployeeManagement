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
import com.neethu.employeemanagementserver.mapper.EmployeeMapper;
import com.neethu.employeemanagementserver.model.EmployeeDTO;
import com.neethu.employeemanagementserver.model.EmployeeRequest;
import com.neethu.employeemanagementserver.model.EmployeeResponse;
import com.neethu.employeemanagementserver.service.EmployeeOrchestrator;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {

	@Autowired
	EmployeeOrchestrator employeeOrchestrator;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeResponse>> findAll() {
		List<EmployeeDTO> employeeDTOs = employeeOrchestrator.findAll();
		
		List<EmployeeResponse> employeeResponses = employeeMapper.mapToEmployeeResponses(employeeDTOs);

		return ResponseEntity.ok(employeeResponses);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponse> findById(@PathVariable("id") Long id) {
		EmployeeDTO employeeDTO = employeeOrchestrator.findById(id);

		EmployeeResponse employeeResponse = employeeMapper.mapToEmployeeResponse(employeeDTO);
		
		return ResponseEntity.ok(employeeResponse);
	}

	@PostMapping
	public ResponseEntity<EmployeeResponse> insert(@RequestBody EmployeeRequest employeeRequest) {
		EmployeeDTO employeeDTO = employeeMapper.mapToEmployeeDTO(employeeRequest);
		
		EmployeeDTO newEmployeeDTO = employeeOrchestrator.insert(employeeDTO);
		EmployeeResponse employeeResponse = employeeMapper.mapToEmployeeResponse(newEmployeeDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
	}
	
	@GetMapping("/search/name/{name}")
    public ResponseEntity<List<EmployeeResponse>> searchByName(@PathVariable("name") String name) {
        List<EmployeeDTO> employeeDTOs = employeeOrchestrator.searchByEmployeeName(name);

        List<EmployeeResponse> employeeResponse = employeeMapper.mapToEmployeeResponses(employeeDTOs);

        return ResponseEntity.ok(employeeResponse);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponse> updateById(@PathVariable("id") Long id, @RequestBody EmployeeRequest employeeRequest) {
		EmployeeDTO employeeDTO = employeeMapper.mapToEmployeeDTO(employeeRequest);

		EmployeeDTO updatedEmployeeDTO = employeeOrchestrator.updateById(id, employeeDTO);

		EmployeeResponse employeeResponse = employeeMapper.mapToEmployeeResponse(updatedEmployeeDTO);
		
		return ResponseEntity.ok(employeeResponse);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		 employeeOrchestrator.deleteById(id);
	}
}
