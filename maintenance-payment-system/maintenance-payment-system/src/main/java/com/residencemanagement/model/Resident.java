package com.residencemanagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "residents")
@Data
public class Resident {
    @Id
    private String id;
    private String name;
    private String flatNumber;
    private String contactNumber;
}