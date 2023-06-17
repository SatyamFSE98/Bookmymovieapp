package com.bookmymoviesapp.authorizationService.controller;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookmymoviesapp.authorizationService.model.Role;
import com.bookmymoviesapp.authorizationService.service.RoleService;
import com.bookmymoviesapp.authorizationService.service.UserService;





@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	 @Autowired
	 private RoleService roleservice;  
	 
	 @Autowired
	 private UserService userService;
	 
	 @PostMapping({"/createNewRole"})
	public Role createNewRole(@RequestBody Role role) {
		 return roleservice.createNewRole(role);
		
		 
		
	}
	 
	 @PostConstruct
	 public void initRolesAnduser() {
		 userService.initRolesAndUser();
	 }

}
