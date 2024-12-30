package com.society.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class SocietyDTO {
    private String id;

    @NotBlank(message = "Society name is required")
    private String name;

    private AddressDTO address;
    private String adminId;
    private int totalBlocks;

    @Data
    public static class AddressDTO {
        private String street;
        private String city;
        private String state;
        private String pincode;
    }
}
