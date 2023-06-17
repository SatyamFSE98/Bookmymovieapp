package com.bookmymoviesapp.authorizationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmymoviesapp.authorizationService.model.Role;
import com.bookmymoviesapp.authorizationService.repository.RoleDao;



@Service
public class RoleService {
	@Autowired
	private RoleDao roleDao;
	public Role createNewRole(Role role) {
		return roleDao.save(role);
	}

}