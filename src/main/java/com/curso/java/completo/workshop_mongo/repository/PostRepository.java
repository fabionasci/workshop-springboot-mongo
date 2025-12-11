package com.curso.java.completo.workshop_mongo.repository;

import com.curso.java.completo.workshop_mongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{'title': { $regex: ?0, $options: 'i'}}")
    List<Post> searchTitle(String title);

    List<Post> findByTitleContainingIgnoreCase(String title);
}
