package com.society.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Document(collection = "societies")
public class Society {
    @Id
    private String id;

    @NotBlank(message = "Society name is required")
    private String name;

    private Address address;
    private String adminId;
    private int totalBlocks;
    private LocalDateTime createdAt = LocalDateTime.now();
}

@Data
class Address {
    private String street;
    private String city;
    private String state;
    private String pincode;
}