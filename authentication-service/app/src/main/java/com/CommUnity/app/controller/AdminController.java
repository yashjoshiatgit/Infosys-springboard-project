package com.CommUnity.app.controller;

import com.CommUnity.app.model.Admin;
import com.CommUnity.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for managing Admin-related operations.
 */
@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signUpAdmin(@Valid @RequestBody Admin admin) {
        String message = adminService.saveAdmin(admin);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<Map<String, String>> signInAdmin(@RequestParam String username, @RequestParam String password) {
        String token = adminService.authenticate(username, password);
        Map<String, String> response = new HashMap<>();
        if (token != null) {
            response.put("token", token);
            response.put("message", "Sign-in successful! Welcome back.");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid username or password.");
            return ResponseEntity.status(401).body(response);
        }
    }

}
