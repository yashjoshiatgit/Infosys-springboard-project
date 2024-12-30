package com.society.repository;

import com.society.model.Flat;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface FlatRepository extends MongoRepository<Flat, String> {
    List<Flat> findBySocietyId(String societyId);
    boolean existsByNumberAndBlockAndSocietyId(String number, String block, String societyId);
}