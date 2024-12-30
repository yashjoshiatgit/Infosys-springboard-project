package com.CommUnity.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotEmpty;

/**
 * Represents a User in the community.
 */
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    private String role = "USER";
    private String name;
    private String phoneNumber;
    private String societyName;
    private String city;
    private String district;
    private String postal;
}
