package com.residencemanagement.dto;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private String billId;
    private double amount;
    private String paymentMethod;
}