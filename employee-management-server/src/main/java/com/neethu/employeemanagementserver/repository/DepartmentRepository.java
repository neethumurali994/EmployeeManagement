package com.neethu.employeemanagementserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.neethu.employeemanagementserver.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
