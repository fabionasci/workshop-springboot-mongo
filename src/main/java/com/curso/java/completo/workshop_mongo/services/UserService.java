package com.curso.java.completo.workshop_mongo.services;

import com.curso.java.completo.workshop_mongo.domain.User;
import com.curso.java.completo.workshop_mongo.dto.UserDto;
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

    public User insert(UserDto userDto){
        User user = fromDto(userDto);
        return userRepository.save(user);
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }

    private User fromDto(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }
}
