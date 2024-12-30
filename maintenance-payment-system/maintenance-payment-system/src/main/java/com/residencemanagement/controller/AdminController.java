package com.residencemanagement.controller;

import com.residencemanagement.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/pending-payments")
    public ResponseEntity<?> getPendingPayments() {
        return ResponseEntity.ok(billingService.getPendingPayments());
    }
}
