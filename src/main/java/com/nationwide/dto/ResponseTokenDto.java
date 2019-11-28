package com.nationwide.dto;

/**
 * This is returned to the user 
 * This is so we don't expose the user ID
 * This is the token class with the user ID removed
 * @author n/a
 *
 */
public class ResponseTokenDto {

	private String username;
	private String bearerToken;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBearerToken() {
		return bearerToken;
	}
	public void setBearerToken(String bearerToken) {
		this.bearerToken = bearerToken;
	}
	
	
}
