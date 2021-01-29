package com.ms.cat.model;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String userId;
	
	private List<String> roles;

	public JwtResponse(String accessToken, Long id, String userId,  List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.userId = userId;
		
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getUserid() {
		return userId;
	}

	public void setUsername(String userId) {
		this.userId = userId;
	}

	public List<String> getRoles() {
		return roles;
	}
}
