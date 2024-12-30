package com.CommUnity.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotEmpty;

/**
 * Represents an Admin in the community.
 */
@Data
@Document(collection = "admins")
public class Admin {
    @Id
    private String id;

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    private String role = "ADMIN";
    private String name;
    private String phoneNumber;
    private String societyName;
    private String flatNumber;
    private String postal;
}
