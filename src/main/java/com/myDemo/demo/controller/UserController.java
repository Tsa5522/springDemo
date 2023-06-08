package com.myDemo.demo.controller;

import com.myDemo.demo.entity.User;
import com.myDemo.demo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final MyUserDetailsService myUserDetailsService;

    @Autowired
    public UserController(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User existingUser = myUserDetailsService.loadUserByUsername(user.getUsername());
        if (existingUser != null) {
            return new ResponseEntity<>(new ResponseMessage("Error: User already exists!"), HttpStatus.BAD_REQUEST);
        }
        try {
            myUserDetailsService.createUser(user.getUsername(), user.getPassword());
            return new ResponseEntity<>(new ResponseMessage("User created successfully!"), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseMessage("Error: User could not be created!"), HttpStatus.BAD_REQUEST);
        }
    }
}

class ResponseMessage {
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
