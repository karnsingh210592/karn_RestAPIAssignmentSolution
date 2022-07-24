package com.gls.employeeMS.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.gls.employeeMS.entity.Employee;
import com.gls.employeeMS.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeesController 
{

	@Autowired
	private EmployeeService employeeService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String listEmployees(Model theModel) 
	{
		

		// get Employees from db
		List<Employee> theEmployees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("Employees", theEmployees);
		

		return "list-Employees";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) 
	{

		// create model attribute to bind form data
		Employee theEmployee = new Employee();

		theModel.addAttribute("Employee", theEmployee);

		return "Employee-form";
	}

	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) 
	{

		// get the Book from the service
		Employee theEmployee = employeeService.findById(theId);


		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Employee", theEmployee);

		// send over to our form
		return "Employee-form";			
	}


	@PostMapping("/save")
	public String saveEmployee(@RequestParam("id") int id,
		 @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,@RequestParam("email") String email) 
	{

		System.out.println(id);
		Employee theEmployee;
		if(id!=0)
		{
			theEmployee=employeeService.findById(id);
			theEmployee.setFirstName(firstName);
			theEmployee.setLastName(lastName);
			theEmployee.setEmail(email);
		}
		else
		{
			theEmployee=new Employee(firstName,lastName, email);
		}
		
		// save the Book
		employeeService.save(theEmployee);


		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) 
	{

		// delete the employee
		employeeService.deleteById(theId);

		// redirect to /employees/list
		return "redirect:/employees/list";

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) 
	{

		ModelAndView model = new ModelAndView();

		if (user != null) 
		{
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} 
		else 
		{
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}