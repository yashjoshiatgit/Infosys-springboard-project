package com.society.service;

import com.society.model.Flat;
import com.society.model.FlatStatus;
import com.society.repository.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlatService {

    @Autowired
    private FlatRepository flatRepository;

    public Flat createFlat(Flat flat) {
        if (flatRepository.existsByNumberAndBlockAndSocietyId(
                flat.getNumber(), flat.getBlock(), flat.getSocietyId())) {
            throw new RuntimeException("Flat already exists in this block");
        }
        return flatRepository.save(flat);
    }

    public List<Flat> getSocietyFlats(String societyId) {
        return flatRepository.findBySocietyId(societyId);
    }

    public Flat assignResident(String flatId, String residentId) {
        Flat flat = flatRepository.findById(flatId)
                .orElseThrow(() -> new RuntimeException("Flat not found"));
        flat.setCurrentResidentId(residentId);
        flat.setStatus(FlatStatus.OCCUPIED);
        return flatRepository.save(flat);
    }
}