package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Registration DTO")

public class RegisterUser {
	@ApiModelProperty(value = "User Id")
	private int id;

	@ApiModelProperty(value = "User firstName")
	private String firstName;
	@ApiModelProperty(value = "User lastName")
	private String lastName;
	@ApiModelProperty(value = "User userName")
	private String userName;
	@ApiModelProperty(value = "User Password like (alphabetnumber)")
	private String password;
	@ApiModelProperty(value = "User email must like @.com")
	private String email;
	@ApiModelProperty(value = "phone like 12345667")
	private int phone;
	@ApiModelProperty(value = "User Role")
	private String role;
	
	public RegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RegisterUser(int id, String firstName, String lastName, String userName, String password, String email,
			int phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.role = role;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RegisterUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", email=" + email + ", phone=" + phone + ", role=" + role
				+ "]";
	}

	
	
}
