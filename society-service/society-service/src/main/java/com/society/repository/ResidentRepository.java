package com.society.repository;

import com.society.model.Resident;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ResidentRepository extends MongoRepository<Resident, String> {
    List<Resident> findBySocietyId(String societyId);
    List<Resident> findByFlatId(String flatId);
}