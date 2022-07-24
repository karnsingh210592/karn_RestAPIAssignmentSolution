package com.gls.employeeMS.service;

import java.util.List;

import com.gls.employeeMS.entity.Employee;
import com.gls.employeeMS.repository.EmployeeRepository;
import com.gls.employeeMS.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{


	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() 
    {
		// TODO Auto-generated method stub
		List<Employee> employees=employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee findById(int theId) 
    {
		// TODO Auto-generated method stub
		return employeeRepository.findById(theId).get();
	}

	@Override
	public void save(Employee theEmployee) 
    {
		// TODO Auto-generated method stub
		employeeRepository.save(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) 
    {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);
		
	}

}