package com.society.service;

import com.society.model.Society;
import com.society.repository.SocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocietyService {

    @Autowired
    private SocietyRepository societyRepository;

    public Society createSociety(Society society) {
        if (societyRepository.existsByName(society.getName())) {
            throw new RuntimeException("Society with this name already exists");
        }
        return societyRepository.save(society);
    }

    public Society getSociety(String id) {
        return societyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Society not found"));
    }

    public Society updateSociety(String id, Society society) {
        Society existingSociety = getSociety(id);
        // Update fields
        existingSociety.setName(society.getName());
        existingSociety.setAddress(society.getAddress());
        existingSociety.setTotalBlocks(society.getTotalBlocks());
        return societyRepository.save(existingSociety);
    }
}