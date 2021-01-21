package com.gateway.dto;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

	
	private static final long serialVersionUID = -7724286646991522442L;
	private String jwt;

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
}
