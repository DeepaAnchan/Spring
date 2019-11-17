package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	
	public List<Employee> findEmployees();
	public Employee saveEmployee(Employee employee);
}
