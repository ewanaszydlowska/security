package com.spring.security.playground.service;

import com.spring.security.playground.model.domain.User;
import com.spring.security.playground.model.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerNewUserAccount(UserDto userDto);
}
