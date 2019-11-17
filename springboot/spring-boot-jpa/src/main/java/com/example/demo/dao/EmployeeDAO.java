package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDAO {
	
	
	public List<Employee> getAllEmployee();	
	
	public Employee findById(int theId);
	
	public List<Employee> findByLastName(String lastName);

	
	//public void save(Employee theEmployee);
	public Employee save(Employee employee);
	
	public void deleteById(int theId);
	
	public void update(Employee employee);


}