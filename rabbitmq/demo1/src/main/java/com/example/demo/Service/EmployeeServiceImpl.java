package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.entity.Employee;


@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	public List<Employee> findEmployees(){
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Employee> emp =   employeeRepository.findById(id);
		Employee employee = null;
		if(emp.isPresent()) {
			employee = emp.get();
		}
		else {
			throw new RuntimeException("The employee record cannot be found.");
		}
		
		return employee;
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		//Employee emp = employeeRepository.findById(id);
		employeeRepository.deleteById(id);
		
	}

	@Override
	public List<Employee> searchBy(String theFirstName, String theLastName) {
		// TODO Auto-generated method stub
		return employeeRepository.
				findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
						theFirstName, theLastName);
	}
}
