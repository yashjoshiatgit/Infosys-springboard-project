package com.example.complaint.service;

import com.example.complaint.model.ServiceRequest;
import com.example.complaint.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRequestService {
    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    public ServiceRequest createServiceRequest(ServiceRequest serviceRequest) {
        serviceRequest.setStatus("open");
        return serviceRequestRepository.save(serviceRequest);
    }

    public ServiceRequest getServiceRequestById(String id) {
        return serviceRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("Service Request not found"));
    }


}