package com.example.springbootblogrestapi.repository;

import com.example.springbootblogrestapi.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);
    Optional<User> deleteById(long id);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
