package com.olx.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class LoginServiceDelegateImpl implements LoginServiceDelegate {

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	@CircuitBreaker(name = "VALIDATE-CIRCUIT-BREAKER" , fallbackMethod = "fallbackIsValidUser")
	public boolean isValidUser(String authtoken) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", authtoken);
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<Boolean> result = this.restTemplate.exchange("http://OLX-GATEWAY/olx/user/token/validate",HttpMethod.GET,entity,Boolean.class);
     	return result.getBody();
	}

	public boolean fallbackIsValidUser(String authtoken , Exception ex) {
		System.out.println("Inside fallbackIsValidUser: " + ex);
		return false;
		
	}


}
