package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findEmployees();
	public Employee saveEmployee(Employee employee);
	public Employee findEmployeeById(Integer id);
	public void deleteEmployee(Integer id);
	public List<Employee> searchBy(String theFirstName, String theLastName);

}
