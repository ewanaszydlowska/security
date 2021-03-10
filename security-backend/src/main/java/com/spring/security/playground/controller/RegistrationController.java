package com.spring.security.playground.controller;

import com.spring.security.playground.model.domain.User;
import com.spring.security.playground.model.dto.UserDto;
import com.spring.security.playground.service.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/signup")
public class RegistrationController {

    private final UserDetailsService userDetailsService;

    private final UserService userService;

    public RegistrationController(UserDetailsService userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @PostMapping
    public User registerUser(@Valid @RequestBody UserDto userDto) {
        return userService.registerNewUserAccount(userDto);
    }
}
