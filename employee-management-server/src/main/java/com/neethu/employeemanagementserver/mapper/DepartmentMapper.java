package com.neethu.employeemanagementserver.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import com.neethu.employeemanagementserver.entity.Department;
import com.neethu.employeemanagementserver.entity.Employee;
import com.neethu.employeemanagementserver.model.DepartmentDTO;
import com.neethu.employeemanagementserver.model.DepartmentRequest;
import com.neethu.employeemanagementserver.model.DepartmentResponse;
import com.neethu.employeemanagementserver.model.EmployeeDTO;
import com.neethu.employeemanagementserver.model.EmployeeRequest;
import com.neethu.employeemanagementserver.model.EmployeeResponse;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface DepartmentMapper {

	DepartmentDTO mapToDepartmentDTO(DepartmentRequest departmentRequest);

    @Mapping(target = "id", ignore = true)
    Department mapToDepartment(DepartmentDTO departmentDTO, @MappingTarget Department department);

    Department mapToDepartment(Department department);

    DepartmentDTO mapToDepartmentDTO(Department department);

    DepartmentResponse mapToDepartmentResponse(DepartmentDTO departmentDTO);

	List<DepartmentDTO> mapToDepartmentDTOs(List<Department> departments);
	
	List<DepartmentResponse> mapToDepartmentResponses(List<DepartmentDTO> departmentDTO);

}
