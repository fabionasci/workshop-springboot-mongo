package com.curso.java.completo.workshop_mongo.services;

import com.curso.java.completo.workshop_mongo.domain.Post;
import com.curso.java.completo.workshop_mongo.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        return postRepository.searchTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
