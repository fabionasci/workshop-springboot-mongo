package com.curso.java.completo.workshop_mongo.services;

import com.curso.java.completo.workshop_mongo.domain.Post;
import com.curso.java.completo.workshop_mongo.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id){
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> findByTitle(String title){
        return postRepository.findByTitle(title);
    }
}
