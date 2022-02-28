package com.olx.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.olx.dto.AuthenticationRequest;
import com.olx.dto.RegisterUser;
import com.olx.exception.InvalidsUserNameException;
import com.olx.security.JwtUtil;
import com.olx.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/olx")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	UserDetailsService userDetailsService;
	


	//1
	@PostMapping(value = "/user/authenticate", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),
					authenticationRequest.getPassword()));
		}
		catch(AuthenticationException exception) { //login failed
			throw new InvalidsUserNameException(); //InvalidUserCrendentialException
		}
		//login Successful
		String authToken = jwtUtil.generateToken(authenticationRequest.getUserName());
		return new ResponseEntity<String>(authToken, HttpStatus.OK);
	}

	//2
	@DeleteMapping(value = "/user/logout")
	public boolean userLogout(@RequestHeader("auth-token") String authToken) {
		return userService.userLogout(authToken);
	}

	//3
	@PostMapping(value = "/user/register", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<RegisterUser> registeruser(@RequestBody RegisterUser registerUser) {
		return new ResponseEntity<>(userService.registerUser(registerUser), HttpStatus.CREATED);

	}
	
	//4
	@GetMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value="Read all User", notes = "Returns all User Details")
	public List<RegisterUser> userInfo() {
		return userService.userInfo();
	}

	//5
	@GetMapping(value = "/token/validate")
	public ResponseEntity<Boolean> validation(@RequestHeader("Authentication") String authToken) {
		String actualAuthToken = authToken.substring(7, authToken.length());
		String username = jwtUtil.extractUsername(actualAuthToken);
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		boolean isValid = jwtUtil.validateToken(actualAuthToken, userDetails);
		if(isValid)
			return new ResponseEntity<Boolean>(isValid, HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(isValid, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@GetMapping(value="/user/{id}", produces= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value="Read User by Id", notes = "Returns a specific User by its Id")
	public ResponseEntity<RegisterUser> getUserById(@ApiParam(name = "id", required = true) @PathVariable("id")int userId) {
	return new ResponseEntity<RegisterUser>(userService.getUserById(userId), HttpStatus.OK);
	}

}