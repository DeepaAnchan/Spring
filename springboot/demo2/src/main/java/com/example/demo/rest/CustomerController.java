package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {
	private List<Customer>  customers=new ArrayList<Customer>();

	Logger log=LoggerFactory.getLogger(CustomerController.class);
	
	@PostConstruct
	public void init()
	{
		log.info("post construct worked..");
		customers.add(new Customer("John", "Doe", "john@spring.io"));
		customers.add(new Customer("Shane", "Warne", "shane@luv2code.com"));
		customers.add(new Customer("Lara", "Dutta", "lara@luv2code.com"));

	}
	

	@GetMapping("/customers")
	public List<Customer> getAllCustomer()
	{
		return customers;
	}
	
	@PostMapping("/customers")
	public List<Customer> save(Customer customer) {
		// TODO Auto-generated method stub
		customers.add(new Customer("Arav", "Bose", "arav@spring.io"));
		
		return customers;
	}
	
	@PreDestroy
	public void destroy()
	{
		log.info("pre destroy worked..");
		customers=null;
	}
}