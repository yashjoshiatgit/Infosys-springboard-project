package com.residencemanagement.repository;

import com.residencemanagement.model.Resident;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResidentRepository extends MongoRepository<Resident, String> {
}
