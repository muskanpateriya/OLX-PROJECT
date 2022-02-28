package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "User DTO")
public class UserDto {
	@ApiModelProperty(value = "User Identification")
	private int userId;
	@ApiModelProperty(value = "User First Name")
	private String firstName;
	@ApiModelProperty(value = "User Last Name")
	private String lastName;
	@ApiModelProperty(value = "User User-Name")
	private String userName;
	@ApiModelProperty(value = "User Password")
	private String password;
	@ApiModelProperty(value = "User Email")
	private String email;
	@ApiModelProperty(value = "User Phone Number")
	private String phone;
	
	public UserDto() {
		super();
	}
	
	
	public UserDto(int userId, String firstName, String lastName, String userName, String password, String email,
			String phone) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserDto [UserId="+userId+" firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", phone=" + phone + "]";
	}
	

}
