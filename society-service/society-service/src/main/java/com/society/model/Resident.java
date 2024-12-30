package com.society.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Document(collection = "residents")
public class Resident {
    @Id
    private String id;

    private String userId;
    private String societyId;
    private String flatId;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone number is required")
    private String phone;

    @Email(message = "Invalid email format")
    private String email;

    private ResidentType residentType;
    private ResidentStatus status = ResidentStatus.ACTIVE;
    private LocalDateTime moveInDate = LocalDateTime.now();
}

