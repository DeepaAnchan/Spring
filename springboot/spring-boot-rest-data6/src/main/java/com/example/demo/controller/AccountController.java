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

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers/{customerId}/accounts")
	public Page<Account> getAllCommentsByPostId(@PathVariable(value = "customerId") Long customerId, Pageable pageable) {
		return accountRepository.findByCustomerId(customerId, pageable);
	}

	@PostMapping("/customers/{customerId}/accounts")
	public Account createComment(@PathVariable(value = "customerId") Long customerId, @Valid @RequestBody Account account) {
		return customerRepository.findById(customerId).map(customer -> {
			account.setCustomer(customer);
			return accountRepository.save(account);
		}).orElseThrow(() -> new ResourceNotFoundException("CustomerId " + customerId + " not found"));
	}

	@PutMapping("/customers/{customerId}/accounts/{accountId}")
	public Account updateComment(@PathVariable(value = "customerId") Long customerId,
			@PathVariable(value = "accountId") Long accountId, @Valid @RequestBody Account accountRequest) {
		

		if (!customerRepository.existsById(customerId)) {
			throw new ResourceNotFoundException("CustomerId " + customerId + " not found");
		}

		return accountRepository.findById(accountId).map(account -> {
			account.setAccoutType(accountRequest.getAccoutType());
			return accountRepository.save(account);
		}).orElseThrow(() -> new ResourceNotFoundException("AccountId " + accountId + "not found"));
	}

	@DeleteMapping("/customers/{customerId}/accounts/{accountId}")
	public ResponseEntity<?> deleteComment(@PathVariable(value = "customerId") Long customerId,
			@PathVariable(value = "accountId") Long accountId) {
		
		return accountRepository.findByAccountIdAndCustomerId(accountId, customerId).map(account -> {
			accountRepository.delete(account);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Account not found with id " + accountId + " and customer " + customerId));
	}
}
