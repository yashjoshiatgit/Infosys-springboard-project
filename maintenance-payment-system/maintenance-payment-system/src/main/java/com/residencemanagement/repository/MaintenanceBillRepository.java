package com.residencemanagement.repository;

import com.residencemanagement.model.MaintenanceBill;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaintenanceBillRepository extends MongoRepository<MaintenanceBill, String> {
}
