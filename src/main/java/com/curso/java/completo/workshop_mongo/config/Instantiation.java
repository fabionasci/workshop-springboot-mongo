package com.curso.java.completo.workshop_mongo.config;

import com.curso.java.completo.workshop_mongo.domain.Post;
import com.curso.java.completo.workshop_mongo.domain.User;
import com.curso.java.completo.workshop_mongo.repository.PostRepository;
import com.curso.java.completo.workshop_mongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class Instantiation implements CommandLineRunner {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));

        System.out.println("Limpando banco de dados");
        userRepository.deleteAll();

        System.out.println("Instanciando objetos");
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje!", maria);

        System.out.println("Salvando objetos");
        userRepository.save(maria);
        userRepository.save(alex);
        userRepository.save(bob);

        postRepository.save(post1);
    }
}
