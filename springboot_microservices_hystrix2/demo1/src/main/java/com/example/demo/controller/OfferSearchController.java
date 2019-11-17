package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Offers;
import com.example.demo.repository.OfferSearchRepository;

@RefreshScope
@RestController
@RequestMapping("/api")
public class OfferSearchController {
	
	@Autowired
	private OfferSearchRepository offerSearchRepositorys;

	@RequestMapping("/offers")
	public List<Offers> findAll() {
		return offerSearchRepositorys.findAll();
	}
	
	
	

}
