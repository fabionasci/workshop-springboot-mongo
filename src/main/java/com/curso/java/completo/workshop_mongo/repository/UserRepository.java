package com.curso.java.completo.workshop_mongo.repository;

import com.curso.java.completo.workshop_mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
