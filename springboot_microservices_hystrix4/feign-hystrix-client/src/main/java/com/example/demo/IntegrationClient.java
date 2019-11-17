package com.example.demo;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class IntegrationClient {
	@Autowired
	private OffersServiceClient offersClient;

	@Autowired
	private RecommendationServiceClient recommnedationClient;

	public Collection<Product> getRecommendationFallback() {
		System.out.println("=======getRecommendationFallback=========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getRecommendationFallback")
	public Collection<Product> getRecommendations() {
		return this.recommnedationClient.getRecommendations();
	}

	public Collection<Offers> getOffersFallback() {
		System.out.println("===========getOffersFallback===========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getOffersFallback")
	public Collection<Offers> getOffers() {
		return this.offersClient.getCurrentOffers();
	}
	
	public void setOffersFallback(Offers offer) {
		System.out.println("===========setOffersFallback===========");
		
	}
	
	@HystrixCommand(fallbackMethod = "setOffersFallback")
	public void postOffers(Offers offer) {
		this.offersClient.postCurrentOffer(offer);
	}


}