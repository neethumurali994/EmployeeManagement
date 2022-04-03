package com.neethu.employeemanagementserver.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neethu.employeemanagementserver.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("select e from Employee e where lower(e.employeeName) like lower(concat('%', :name, '%')) or upper(e.employeeName) like upper(concat('%', :name, '%')) order by e.id")
	List<Employee> searchByEmployeeName(String name, Pageable pageable);

}
