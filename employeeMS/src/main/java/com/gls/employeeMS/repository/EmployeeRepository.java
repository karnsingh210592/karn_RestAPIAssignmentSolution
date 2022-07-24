package com.gls.employeeMS.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gls.employeeMS.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{

}