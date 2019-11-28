package com.nationwide.dto;

/**
 * Request data transfer object to control incoming data
 * @see Account
 * @author willg
 *
 */
public class RequestAccountDto {
	
	String username;
	String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
