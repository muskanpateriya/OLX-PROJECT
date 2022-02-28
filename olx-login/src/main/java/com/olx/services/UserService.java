package com.olx.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.olx.dto.AuthenticationRequest;
import com.olx.dto.RegisterUser;


public interface UserService {

	public RegisterUser registerUser(RegisterUser registerUser);//3

	public ResponseEntity<String> authrntication(AuthenticationRequest authenticationRequest);//1
	
	public boolean userLogout(String authToken);//2

	public boolean validation(String authToken);//5

	public List<RegisterUser> userInfo();//4

	public RegisterUser getUserById(int userId);//6


}
