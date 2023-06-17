package com.moviebookingAuthTest.authorizationService.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bookmymoviesapp.authorizationService.model.Role;
import com.bookmymoviesapp.authorizationService.model.User;
import com.bookmymoviesapp.authorizationService.repository.RoleDao;
import com.bookmymoviesapp.authorizationService.repository.UserDao;
import com.bookmymoviesapp.authorizationService.service.UserService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserDao userDao;

    @Mock
    RoleDao roleDao;

    @Mock
    PasswordEncoder passwordEncoder;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void registerNewUser_success() {
        User user = new User();
        user.setUserPassword("password");

        Role role = new Role();
        role.setRoleName("User");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);

        when(roleDao.findById("User")).thenReturn(Optional.of(role));
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userDao.save(any(User.class))).thenReturn(user);

        HttpStatus status = userService.registerNewUser(user);

        verify(userDao, times(1)).save(user);
        assertEquals(HttpStatus.OK, status);
    }

//    @Test
//    public void registerNewUser_failure() {
//        User user = new User();
//        user.setUserPassword("password");
//
//        Role role = new Role();
//        role.setRoleName("User");
//
//        // Return the role when findById is called
//        when(roleDao.findById("User")).thenReturn(Optional.of(role));
//
//        HttpStatus status = userService.registerNewUser(user);
//
//        verify(userDao, times(0)).save(user);
//        assertEquals(HttpStatus.BAD_REQUEST, status);
//    }

}
