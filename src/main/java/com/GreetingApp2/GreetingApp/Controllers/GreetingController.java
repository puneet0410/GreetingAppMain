package com.GreetingApp2.GreetingApp.Controllers;




import com.GreetingApp2.GreetingApp.Service.GreetingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.GreetingApp2.GreetingApp.Entity.Greeting;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // ✅ GET method to retrieve all greetings
    @GetMapping
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // ✅ POST method to add a new greeting
    @PostMapping
    public Greeting createGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting);
    }
}


//http://localhost:8080/greetings (POST, GET)

//[
//        {
//        "id": 1,
//        "message": "Hello, Spring Boot!"
//        },
//        {
//        "id": 2,
//        "message": "Hello, Nomicy!"
//        },
//        {
//        "id": 3,
//        "message": "Hello, Sanjana!"
//        }
//        ]