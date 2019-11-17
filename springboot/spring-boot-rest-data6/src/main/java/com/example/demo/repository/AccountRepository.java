package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Page<Account> findByCustomerId(Long customerId, Pageable pageable);

	Optional<Account> findByAccountIdAndCustomerId(Long accountid, Long customerId);

}