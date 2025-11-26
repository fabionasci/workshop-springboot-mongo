package com.curso.java.completo.workshop_mongo.config;

import com.curso.java.completo.workshop_mongo.domain.User;
import com.curso.java.completo.workshop_mongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    private UserRepository userRepository;

    public Instantiation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Limpando banco de dados");
        userRepository.deleteAll();

        System.out.println("Instanciando objetos");
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        System.out.println("Salvando objetos");
        userRepository.save(maria);
        userRepository.save(alex);
        userRepository.save(bob);
    }
}
