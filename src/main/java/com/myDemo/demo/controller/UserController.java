package com.myDemo.demo.controller;


import com.myDemo.demo.entity.User;
import com.myDemo.demo.entity.UserDTO;
import com.myDemo.demo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
//@RequestMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/users")
public class UserController {

    private final MyUserDetailsService myUserDetailsService;

    @Autowired
    public UserController(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        try {
            myUserDetailsService.createUser(userDTO);
            return new ResponseEntity<>(Map.of("message", "User created successfully!"), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // This will log the stack trace to your console
            return new ResponseEntity<>(Map.of("message", "Error: User could not be created!"), HttpStatus.BAD_REQUEST);
        }
    }
}


