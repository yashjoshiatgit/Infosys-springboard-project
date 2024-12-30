package com.residencemanagement.controller;

import com.residencemanagement.dto.PaymentRequestDTO;
import com.residencemanagement.service.StripePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private StripePaymentService stripePaymentService;

    @PostMapping("/make")
    public ResponseEntity<String> makePayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        String response = stripePaymentService.processPayment(paymentRequestDTO);
        return ResponseEntity.ok(response);
    }
}
