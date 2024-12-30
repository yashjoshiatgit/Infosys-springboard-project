package com.example.admin.service;

import com.example.complaint.model.Complaint;
import com.example.complaint.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private ComplaintRepository complaintRepository;

    public Iterable<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Complaint closeComplaint(String id) {
        Complaint complaint = complaintRepository.findById(id).orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setStatus("closed");
        return complaintRepository.save(complaint);
    }

    // Add more admin-specific methods
}