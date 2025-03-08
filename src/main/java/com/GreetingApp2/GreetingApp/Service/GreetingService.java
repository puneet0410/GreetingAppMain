package com.GreetingApp2.GreetingApp.Service;

import com.GreetingApp2.GreetingApp.Entity.Greeting;
import com.GreetingApp2.GreetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @Autowired
    private GreetingRepository greetingRepository;

    // CREATE a new greeting
    public Greeting createGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    // READ all greetings
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // READ a single greeting by ID
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found"));
    }

    // UPDATE a greeting
    public Greeting updateGreeting(Long id, Greeting updatedGreeting) {
        Greeting existingGreeting = getGreetingById(id);
        existingGreeting.setMessage(updatedGreeting.getMessage());
        return greetingRepository.save(existingGreeting);
    }

    // DELETE a greeting
    public void deleteGreeting(Long id) {
        Greeting greeting = getGreetingById(id);
        greetingRepository.delete(greeting);
    }
}