package com.society.dto;

import lombok.Data;
import com.society.model.ResidentType;
import com.society.model.ResidentStatus;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class ResidentDTO {
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
    private ResidentStatus status;
    private LocalDateTime moveInDate;
}