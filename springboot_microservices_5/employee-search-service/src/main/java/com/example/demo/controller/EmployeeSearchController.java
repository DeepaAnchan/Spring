package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeSearchRepository;

@RefreshScope
@RestController
@RequestMapping("/api")
public class EmployeeSearchController {
	
	@Autowired
	private EmployeeSearchRepository employeeSearchRepositorys;

	@RequestMapping("/employees")
	public List<Employee> findAll() {
		return employeeSearchRepositorys.findAll();

	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeSearchRepositorys.save(employee);
	}
	
	@PutMapping("/employees/{employeeId}")
	public Employee updatePost(@PathVariable Long employeeId, @Valid @RequestBody Employee postRequest) {
		return employeeSearchRepositorys.findById(employeeId).map(employee -> {
			
			employee.setCompanyInfo(postRequest.getCompanyInfo());
			employee.setDesignation(postRequest.getDesignation());
			employee.setName(postRequest.getName());
			employee.setPracticeArea(postRequest.getPracticeArea());
			return employeeSearchRepositorys.save(employee);
			
		}).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<?> deletePost(@PathVariable Long employeeId) {
		return employeeSearchRepositorys.findById(employeeId).map(employee -> {
			employeeSearchRepositorys.delete(employee);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));
	}

	

}
