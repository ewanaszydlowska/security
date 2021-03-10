package com.spring.security.playground.controller;

import com.spring.security.playground.model.domain.User;
import com.spring.security.playground.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @GetMapping("/save")
    public User saveUser() {
        return userRepository.save(User.builder().username("Ewa").build());
    }

    @PostMapping("/find/{name}")
    public User getUser(@PathVariable String name) {
        return userRepository.findByUsername(name);
    }
}
