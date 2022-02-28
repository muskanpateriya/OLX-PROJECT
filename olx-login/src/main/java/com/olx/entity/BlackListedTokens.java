package com.olx.entity;



import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "blacklisted_tokens")
public class BlackListedTokens {

	@Id
	private int id;
	private String token;
	private LocalDateTime logoutDate;
	private LocalDateTime expiryDate;
	
	
 
	public BlackListedTokens(int id,String token,LocalDateTime logoutDate,LocalDateTime expiryDate) {
		this.id = id;
		this.token = token;
		this.logoutDate = logoutDate;
		this.expiryDate = expiryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(LocalDateTime logoutDate) {
		this.logoutDate = logoutDate;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "BlackListedTokens [id=" + id + ", token=" + token + ", logoutDate=" + logoutDate + ", expiryDate="
				+ expiryDate + "]";
	}
	
	
	

	
	
}
