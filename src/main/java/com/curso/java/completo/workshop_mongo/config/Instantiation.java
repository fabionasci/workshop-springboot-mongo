package com.curso.java.completo.workshop_mongo.config;

import com.curso.java.completo.workshop_mongo.domain.Post;
import com.curso.java.completo.workshop_mongo.domain.User;
import com.curso.java.completo.workshop_mongo.dto.AuthorDto;
import com.curso.java.completo.workshop_mongo.dto.CommentDto;
import com.curso.java.completo.workshop_mongo.repository.PostRepository;
import com.curso.java.completo.workshop_mongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
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
        postRepository.deleteAll();
        userRepository.deleteAll();

        System.out.println("Instanciando objetos");
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        CommentDto commentDto = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDto(alex));
        CommentDto commentDto2 = new CommentDto("Aproveite!", sdf.parse("21/03/2018"), new AuthorDto(bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
        post1.getComments().addAll(Arrays.asList(commentDto, commentDto2));

        CommentDto commentDto3 = new CommentDto("Tenha um ótimo dia!", sdf.parse("22/03/2018"), new AuthorDto(alex));

        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje!", new AuthorDto(maria));
        post2.getComments().add(commentDto3);

        System.out.println("Salvando objetos");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
