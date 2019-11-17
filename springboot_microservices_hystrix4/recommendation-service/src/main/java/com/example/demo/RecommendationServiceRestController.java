package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationServiceRestController {
	@Autowired
	private ProductRepository productRepository;
	 @RequestMapping(value = "/recommendations", method = RequestMethod.GET)
	    @ResponseBody
	    public List<Product> getCurrentOffers() {
		 return productRepository.findAll();
	    }

}
