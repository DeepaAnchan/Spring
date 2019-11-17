package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	//public void save(Employee employee);
	public Employee save(Employee employee);
	
	public void update(Employee employee);
	
	public List<Employee> findByLastName(String lastName);

	
	public Employee findById(int theId);

	public void deleteById(int theId);

}