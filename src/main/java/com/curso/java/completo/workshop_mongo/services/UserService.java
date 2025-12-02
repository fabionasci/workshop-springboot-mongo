package com.curso.java.completo.workshop_mongo.services;

import com.curso.java.completo.workshop_mongo.domain.User;
import com.curso.java.completo.workshop_mongo.repository.UserRepository;
import com.curso.java.completo.workshop_mongo.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
