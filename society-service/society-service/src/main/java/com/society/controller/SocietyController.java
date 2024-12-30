package com.society.controller;

import com.society.model.Society;
import com.society.service.SocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/societies")
public class SocietyController {

    @Autowired
    private SocietyService societyService;

    @PostMapping
    public ResponseEntity<Society> createSociety(@Valid @RequestBody Society society) {
        return ResponseEntity.ok(societyService.createSociety(society));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Society> getSociety(@PathVariable String id) {
        return ResponseEntity.ok(societyService.getSociety(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Society> updateSociety(
            @PathVariable String id,
            @Valid @RequestBody Society society) {
        return ResponseEntity.ok(societyService.updateSociety(id, society));
    }
}