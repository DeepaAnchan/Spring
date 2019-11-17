package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Offers;

@Repository
public interface OfferSearchRepository extends JpaRepository<Offers, Long> {
	   
	//Page<Employee> findByCustomerId(Long customerId, Pageable pageable);
	List<Offers> findAll();

	


}
