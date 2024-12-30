package com.society.service;

import com.society.model.Resident;
import com.society.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentService {

    @Autowired
    private ResidentRepository residentRepository;
    @Autowired
    private FlatService flatService;

    public Resident createResident(Resident resident) {
        Resident savedResident = residentRepository.save(resident);
        if (resident.getFlatId() != null) {
            flatService.assignResident(resident.getFlatId(), savedResident.getId());
        }
        return savedResident;
    }

    public List<Resident> getSocietyResidents(String societyId) {
        return residentRepository.findBySocietyId(societyId);
    }

    public Resident updateResident(String id, Resident resident) {
        Resident existingResident = residentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resident not found"));
        // Update fields
        existingResident.setName(resident.getName());
        existingResident.setPhone(resident.getPhone());
        existingResident.setEmail(resident.getEmail());
        existingResident.setResidentType(resident.getResidentType());
        existingResident.setStatus(resident.getStatus());
        return residentRepository.save(existingResident);
    }
}