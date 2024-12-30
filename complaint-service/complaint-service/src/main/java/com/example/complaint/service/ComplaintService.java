package com.example.complaint.service;

import com.example.complaint.model.Complaint;
import com.example.complaint.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;

    public Complaint createComplaint(Complaint complaint) {
        complaint.setStatus("open");
        return complaintRepository.save(complaint);
    }

    public Complaint getComplaintById(String id) {
        return complaintRepository.findById(id).orElseThrow(() -> new RuntimeException("Complaint not found"));
    }

    // Add more methods for updating, closing, and listing complaints
}