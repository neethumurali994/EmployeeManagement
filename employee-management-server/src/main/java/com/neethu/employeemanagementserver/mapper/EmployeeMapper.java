package com.neethu.employeemanagementserver.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import com.neethu.employeemanagementserver.entity.Department;
import com.neethu.employeemanagementserver.entity.Employee;
import com.neethu.employeemanagementserver.model.DepartmentDTO;
import com.neethu.employeemanagementserver.model.DepartmentResponse;
import com.neethu.employeemanagementserver.model.EmployeeDTO;
import com.neethu.employeemanagementserver.model.EmployeeRequest;
import com.neethu.employeemanagementserver.model.EmployeeResponse;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
		uses = Department.class)
public interface EmployeeMapper {

	@Mapping(source = "departmentId", target = "department.id")
	EmployeeDTO mapToEmployeeDTO(EmployeeRequest employeeRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "department", ignore = true)
    Employee mapToEmployee(EmployeeDTO employeeDTO, @MappingTarget Employee employee);

    Employee mapToEmployee(Employee employee);

    EmployeeDTO mapToEmployeeDTO(Employee employee);

    EmployeeResponse mapToEmployeeResponse(EmployeeDTO employeeDTO);

	List<EmployeeDTO> mapToEmployeeDTOs(List<Employee> employees);
	
	List<EmployeeResponse> mapToEmployeeResponses(List<EmployeeDTO> employeeDTO);


}
