package com.spring.security.playground.repository;

import com.spring.security.playground.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String firstName);

    User findByEmail(String email);
}
