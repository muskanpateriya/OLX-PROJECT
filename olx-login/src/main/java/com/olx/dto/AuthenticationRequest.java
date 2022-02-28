package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Authentication DTO")

public class AuthenticationRequest {
	@ApiModelProperty(value="User UserName")
private String userName;
	@ApiModelProperty(value="User Password")
private String password;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public AuthenticationRequest() {
	super();
	// TODO Auto-generated constructor stub
}
public AuthenticationRequest(String userName, String password) {
	super();
	this.userName = userName;
	this.password = password;
}
@Override
public String toString() {
	return "AuthenticationRequest [userName=" + userName + ", password=" + password + "]";
}
}
