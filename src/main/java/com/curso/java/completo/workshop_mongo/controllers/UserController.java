package com.curso.java.completo.workshop_mongo.controllers;


import com.curso.java.completo.workshop_mongo.domain.User;
import com.curso.java.completo.workshop_mongo.dto.UserDto;
import com.curso.java.completo.workshop_mongo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>>findAll() {

        List<User> users = userService.findAll();

        List<UserDto> dtoList = users.stream().map(UserDto::new).toList();

        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto>findById(@PathVariable String id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDto userDto){
        User user = userService.insert(userDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
