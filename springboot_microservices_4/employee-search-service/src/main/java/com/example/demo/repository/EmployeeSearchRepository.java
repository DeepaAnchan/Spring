package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Employee;

@Repository
public interface EmployeeSearchRepository extends JpaRepository<Employee, Long> {
	   
	//Page<Employee> findByCustomerId(Long customerId, Pageable pageable);
	List<Employee> findAll();

	


}