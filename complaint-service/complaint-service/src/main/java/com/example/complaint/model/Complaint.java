package com.example.complaint.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "complaints")
@Data
public class Complaint {
    @Id
    private String id;
    private String name;
    private String title;
    private String description;
    private String status;
    private String assignedVendor;


}