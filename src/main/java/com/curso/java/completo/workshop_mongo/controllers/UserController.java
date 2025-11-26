package com.curso.java.completo.workshop_mongo.controllers;


import com.curso.java.completo.workshop_mongo.domain.User;
import com.curso.java.completo.workshop_mongo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>>findAll() {

        List<User> users = userService.findAll();

        return ResponseEntity.ok().body(users);
    }
}
