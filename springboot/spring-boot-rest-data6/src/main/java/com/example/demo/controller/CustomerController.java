package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers")
	public Page<Customer> getAllCustomers(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@PutMapping("/customers/{customerId}")
	public Customer updateCustomer(@PathVariable Long customerId, @Valid @RequestBody Customer customerRequest) {
		
		
			return customerRepository.findById(customerId).map(cust -> {
				cust.setFirstName(customerRequest.getFirstName());
				cust.setLastName(customerRequest.getLastName());
				return customerRepository.save(cust);
			}).orElseThrow(() -> new ResourceNotFoundException("PostId " + customerId + " not found"));
		
	}

	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<?> deleteCustomers(@PathVariable Long customerId) {
		return customerRepository.findById(customerId).map(customer -> {
			customerRepository.delete(customer);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + customerId + " not found"));
	}

}