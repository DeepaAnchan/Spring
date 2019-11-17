package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.OffersRepository;

@RestController
public class OffersServiceRestController {
	@Autowired
	private OffersRepository offersRepository; 
	
	@RequestMapping(value = "/getCurrentOffers", method = RequestMethod.GET)
	@ResponseBody
	public List<Offers> getCurrentOffers() {
		
		return offersRepository.findAll();
	}
	
}
