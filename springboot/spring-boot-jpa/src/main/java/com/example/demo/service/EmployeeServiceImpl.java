package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDao;

	//@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee();
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.save(employee);
		
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDao.findById(theId);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeDao.deleteById(theId);
		
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
		employeeDao.update(employee);
		
	}

	@Override
	public List<Employee> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return employeeDao.findByLastName(lastName);
	}


}