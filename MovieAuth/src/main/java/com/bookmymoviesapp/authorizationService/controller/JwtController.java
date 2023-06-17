package com.bookmymoviesapp.authorizationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookmymoviesapp.authorizationService.model.JwtRequest;
import com.bookmymoviesapp.authorizationService.model.JwtResponse;
import com.bookmymoviesapp.authorizationService.model.User;
import com.bookmymoviesapp.authorizationService.service.JwtService;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:4200")

public class JwtController {
	@Autowired
	private JwtService jwtService;

	@PostMapping({ "/authenticate" })
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println("JWT Auth is called");
		System.out.println(jwtRequest.getUserName());
		User reqUser = new User();
		reqUser.setUserName(jwtRequest.getUserName());
		reqUser.setUserPassword(jwtRequest.getUserPassword());

		JwtResponse res = jwtService.createJwtToken(jwtRequest);

		System.out.println("Logging my response");
		System.out.println("Token -> " + res.getJwtToken());
		System.out.println("User " + res.getUser().getUserName());

		System.out.println("Result : jwt ");
		System.out.println(res);

		return res;
	}
}