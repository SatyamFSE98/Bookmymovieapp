package com.bookmymoviesapp.authorizationService.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmymoviesapp.authorizationService.model.Role;



@Repository
public interface RoleDao extends CrudRepository<Role, String>{
//I can add roles to my db.... and in future from front end if i want user to select roles only from a specified type i can refer this table for valid roles
}

