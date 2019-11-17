package com.mynotes.spring.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OffersServiceRestController {


	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/getCurrentOffers", method = RequestMethod.GET)
	@ResponseBody
	public List<Offers> getCurrentOffers() {

			String url = "http://b8java31.iiht.tech:8761/demo1-service/api/offers";
			System.out.println("URL" + url);

			@SuppressWarnings("unchecked")
			List<Offers> list = restTemplate.getForObject(url, List.class);

			System.out.println("RESPONSE " + list);

			return list;

	}
		
	

}
