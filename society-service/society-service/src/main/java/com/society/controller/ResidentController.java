package com.society.controller;

import com.society.model.Resident;
import com.society.service.ResidentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/residents")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @PostMapping
    public ResponseEntity<Resident> createResident(@Valid @RequestBody Resident resident) {
        return ResponseEntity.ok(residentService.createResident(resident));
    }
    @GetMapping("/society/{societyId}")
    public ResponseEntity<List<Resident>> getSocietyResidents(@PathVariable String societyId) {
        return ResponseEntity.ok(residentService.getSocietyResidents(societyId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resident> updateResident(
            @PathVariable String id,
            @Valid @RequestBody Resident resident) {
        return ResponseEntity.ok(residentService.updateResident(id, resident));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeResident(@PathVariable String id) {
        Objects.requireNonNull(residentService);
        return ResponseEntity.noContent().build();
    }
}