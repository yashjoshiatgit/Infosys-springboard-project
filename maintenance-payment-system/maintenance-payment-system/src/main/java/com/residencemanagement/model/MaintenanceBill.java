package com.residencemanagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "bills")
@Data
public class MaintenanceBill {
    @Id
    private String id;
    private String residentId;
    private double amount;
    private Date dueDate;
    private boolean isPaid;


    // Getters and Setters
}
