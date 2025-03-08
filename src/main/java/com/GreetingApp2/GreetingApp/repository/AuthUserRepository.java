package com.GreetingApp2.GreetingApp.repository;

import com.GreetingApp2.GreetingApp.Entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByEmail(String email);
}