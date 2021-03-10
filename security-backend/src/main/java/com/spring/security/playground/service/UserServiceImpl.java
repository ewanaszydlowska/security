package com.spring.security.playground.service;

import com.spring.security.playground.model.domain.User;
import com.spring.security.playground.model.dto.UserDto;
import com.spring.security.playground.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerNewUserAccount(UserDto userDto)
//            throws UserAlreadyExistException
            {

        if (emailExists(userDto.getEmail())) {
//            throw new UserAlreadyExistException(
//                    "There is an account with that email address:
//                            + userDto.getEmail());
        }

        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .build();

//        user.setRoles(Arrays.asList("ROLE_USER"));
        return userRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
