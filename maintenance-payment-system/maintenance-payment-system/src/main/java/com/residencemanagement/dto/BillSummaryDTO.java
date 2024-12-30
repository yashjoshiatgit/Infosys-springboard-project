package com.residencemanagement.dto;

import lombok.Data;

@Data
public class BillSummaryDTO {
    private String residentName;
    private double totalAmount;
    private boolean isPaid;
}