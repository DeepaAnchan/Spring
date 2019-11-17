package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	//@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}


	@GetMapping(value="/employees")
	public List<Employee> getAllEmployees(){
		
		
		return employeeService.getAllEmployees();
		
		
	}
	

	@PostMapping(value="/employees")
	public Employee save(@RequestBody Employee employee){
			employee.setEmployeeId(0);
			return employeeService.save(employee);
					
		
	}
	
	@PutMapping(value="/employees")
	public String update(@RequestBody Employee employee){
			
		Employee tempEmployee = employeeService.findById(employee.getEmployeeId());
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new EmployeeNotFoundException("Employee id not found - " + employee.getEmployeeId());
		}
		
		employeeService.update(employee);
		
		return "Updated employee id"+ employee.getEmployeeId();
					
		
	}
	
	
	@GetMapping("/employees/getById/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	
	@GetMapping("/employees/getByLastname/{lastName}")
	public List<Employee> getEmployeeByLastname(@PathVariable String lastName) {
		
		List<Employee> theEmployee = employeeService.findByLastName(lastName);
		
		if (theEmployee == null) {
			throw new EmployeeNotFoundException("Employees  not found - " + lastName);
		}
		
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findById(employeeId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
}