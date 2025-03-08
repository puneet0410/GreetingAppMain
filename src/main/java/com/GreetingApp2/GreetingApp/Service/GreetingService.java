package com.GreetingApp2.GreetingApp.Service;

import com.GreetingApp2.GreetingApp.Entity.Greeting;
import com.GreetingApp2.GreetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

//@Service
//public class GreetingService {
//    private final GreetingRepository greetingRepository;
//
//    public GreetingService(GreetingRepository greetingRepository) {
//        this.greetingRepository = greetingRepository;
//    }
//
//    public String getGreetingMessage(String firstName, String lastName) {
//        String message;
//
//        if (firstName != null && !firstName.isBlank() && lastName != null && !lastName.isBlank()) {
//            message = "Hello, " + firstName.trim() + " " + lastName.trim() + "!";
//        } else if (firstName != null && !firstName.isBlank()) {
//            message = "Hello, " + firstName.trim() + "!";
//        } else if (lastName != null && !lastName.isBlank()) {
//            message = "Hello, " + lastName.trim() + "!";
//        } else {
//            message = "Hello World!";
//        }
//
//        // Save the greeting message to the database
//        Greeting greeting = new Greeting(message);
//        greetingRepository.save(greeting);
//
//        return message;
//    }
//}

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}