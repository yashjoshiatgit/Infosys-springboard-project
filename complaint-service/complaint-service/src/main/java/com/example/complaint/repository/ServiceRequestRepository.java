package com.example.complaint.repository;

import com.example.complaint.model.ServiceRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestRepository extends MongoRepository<ServiceRequest, String> {
}