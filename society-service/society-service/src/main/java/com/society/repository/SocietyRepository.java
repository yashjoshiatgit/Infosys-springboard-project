package com.society.repository;

import com.society.model.Society;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SocietyRepository extends MongoRepository<Society, String> {
    boolean existsByName(String name);
}