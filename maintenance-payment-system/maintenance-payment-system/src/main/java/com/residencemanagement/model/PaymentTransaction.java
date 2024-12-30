package com.residencemanagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "transactions")
@Data
public class PaymentTransaction {
    @Id
    private String id;
    private String billId;
    private double amountPaid;
    private Date paymentDate;
    private String paymentMethod;
}