package com.olx.services;



import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.olx.dto.MasterData;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service

public class MasterDataServiceDelegateImpl implements MasterDataServiceDelegate{

	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	@CircuitBreaker(name = "MASTER-DATA-CIRCUIT-BREAKER" , fallbackMethod = "fallbackIsValidUser")
	public MasterData getMasterDataById(String masterDataId) {
		
	MasterData masterData =  this.restTemplate.getForObject("http://OLX-GATEWAY/olx/categories/masterdata", 
			MasterData.class);
	return masterData;
	}
	
//	public MasterData fallbackIsValidUser(String MasterDataId, Exception ex) {
//		System.out.println("Inside fallbackIsValidUser: " + ex);
//		return MasterDataId;
//		
//	}
	
	public boolean fallbackIsValidUser(String masterDataId, Exception ex) {
		System.out.println("Inside fallbackIsValidUser: " + ex);
		return false;
		
	}


	
	
}
