package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	public List<Employee> findAllByOrderByLastNameAsc();
	
	public List<Employee> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
			String theFirstName, String theLastName);
		

}
