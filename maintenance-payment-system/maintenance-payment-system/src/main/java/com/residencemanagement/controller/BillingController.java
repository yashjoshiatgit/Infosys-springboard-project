package com.residencemanagement.controller;

import com.residencemanagement.dto.BillSummaryDTO;
import com.residencemanagement.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bills")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/{residentId}")
    public ResponseEntity<BillSummaryDTO> getBillSummary(@PathVariable String residentId) {
        BillSummaryDTO billSummary = billingService.getBillSummary(residentId);
        return ResponseEntity.ok(billSummary);
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateMonthlyBills() {
        billingService.generateMonthlyBills();
        return ResponseEntity.ok("Monthly bills generated successfully.");
    }
}
