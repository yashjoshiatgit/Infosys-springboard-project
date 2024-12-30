package com.society.controller;

import com.society.model.Flat;
import com.society.service.FlatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/flats")
public class FlatController {

    @Autowired
    private FlatService flatService;

    @PostMapping
    public ResponseEntity<Flat> createFlat(@Valid @RequestBody Flat flat) {
        return ResponseEntity.ok(flatService.createFlat(flat));
    }

    @GetMapping("/society/{societyId}")
    public ResponseEntity<List<Flat>> getSocietyFlats(@PathVariable String societyId) {
        return ResponseEntity.ok(flatService.getSocietyFlats(societyId));
    }

    @PutMapping("/{flatId}/resident/{residentId}")
    public ResponseEntity<Flat> assignResident(
            @PathVariable String flatId,
            @PathVariable String residentId) {
        return ResponseEntity.ok(flatService.assignResident(flatId, residentId));
    }
}