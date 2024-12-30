package com.example.admin.controller;

import com.example.complaint.model.Complaint;
import com.example.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/complaints")
    public ResponseEntity<Iterable<Complaint>> getAllComplaints() {
        return ResponseEntity.ok(adminService.getAllComplaints());
    }

    @PutMapping("/complaints/{id}/close")
    public ResponseEntity<Complaint> closeComplaint(@PathVariable String id) {
        Complaint closedComplaint = adminService.closeComplaint(id);
        return ResponseEntity.ok(closedComplaint);
    }

    // Add more admin-specific endpoints
}