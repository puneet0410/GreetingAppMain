package com.GreetingApp2.GreetingApp.repository;

import com.GreetingApp2.GreetingApp.Entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
