package com.curso.java.completo.workshop_mongo.controllers;


import com.curso.java.completo.workshop_mongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>>findAll() {
        User maria = new User("1", "Maria", "maria@gmail.com");
        User alex = new User("2", "Alex", "alex@gmail.com");
        return ResponseEntity.ok().body(List.of(maria, alex));
    }
}
