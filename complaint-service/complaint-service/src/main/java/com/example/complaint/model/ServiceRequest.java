package com.example.complaint.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "service_requests")
@Data
public class ServiceRequest {
    @Id
    private String id;
    private String name;
    private String title;
    private String description;
    private String status;
    private String assignedVendor;


}