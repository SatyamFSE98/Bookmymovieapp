package com.bookmymoviesapp.service;

import org.springframework.http.HttpStatus;

import com.bookmymoviesapp.model.SessionDTO;

public interface SessionService {

	
	public HttpStatus addSession(SessionDTO sessionDTO) throws Exception;
	
	public String checkSessionUserType() throws Exception;
	
}
