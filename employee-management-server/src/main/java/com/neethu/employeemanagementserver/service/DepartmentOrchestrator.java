package com.neethu.employeemanagementserver.service;

import java.util.List;
import com.neethu.employeemanagementserver.entity.Department;
import com.neethu.employeemanagementserver.mapper.DepartmentMapper;
import com.neethu.employeemanagementserver.model.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentOrchestrator {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<DepartmentDTO> findAll() {
        List<Department> departments = departmentService.findAll();

        List<DepartmentDTO> departmentDTOs = departmentMapper.mapToDepartmentDTOs(departments);

        return departmentDTOs;
    }

    public DepartmentDTO findById(Long id) {
    	Department department = departmentService.findById(id);

        DepartmentDTO departmentDTO = departmentMapper.mapToDepartmentDTO(department);

        return departmentDTO;
    }
  
    public DepartmentDTO insert(DepartmentDTO departmentDTO) {
    	Department department = departmentMapper.mapToDepartment(departmentDTO, new Department());
    	
    	Department newDepartment = departmentService.insert(department);
    	
    	DepartmentDTO newDepartmentDTO = departmentMapper.mapToDepartmentDTO(newDepartment);
    	
    	return newDepartmentDTO;  	
    }
    
    public DepartmentDTO updateById(Long id, DepartmentDTO departmentDTO) {
    	Department newDepartment = departmentService.findById(id);
        
        departmentMapper.mapToDepartment(departmentDTO, newDepartment);
		
        newDepartment = departmentService.insert(newDepartment);
		
        DepartmentDTO newDepartmentDTO = departmentMapper.mapToDepartmentDTO(newDepartment);
    	
    	return newDepartmentDTO;
	}
	
	public void deleteById(Long id) {
		departmentService.deleteById(id);
	}
    
}
