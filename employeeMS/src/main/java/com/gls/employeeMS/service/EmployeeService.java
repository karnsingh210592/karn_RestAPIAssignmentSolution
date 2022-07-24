package com.gls.employeeMS.service;


import java.util.List;
import com.gls.employeeMS.entity.Employee;


public interface EmployeeService 
{
	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);

	//public List<Employee> searchBy(String course, String country);

}