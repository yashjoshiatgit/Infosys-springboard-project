package com.CommUnity.app.controller;

import com.CommUnity.app.model.User;
import com.CommUnity.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for managing User-related operations.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signUpUser(@Valid @RequestBody User user) {
        String message = userService.saveUser(user);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<Map<String, String>> signInUser(@RequestParam String username, @RequestParam String password) {
        String token = userService.authenticate(username, password);
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
