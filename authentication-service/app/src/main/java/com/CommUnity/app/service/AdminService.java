package com.CommUnity.app.service;

import com.CommUnity.app.model.Admin;
import com.CommUnity.app.repository.AdminRepository;
import com.CommUnity.app.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Optional;

@Service
public class AdminService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String saveAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
        logger.info("Admin registered successfully: {}", admin.getUsername());
        return "Admin registered successfully!";
    }

    public String authenticate(String username, String password) {
        logger.info("Attempting to authenticate admin: {}", username);
        Optional<Admin> admin = adminRepository.findByUsername(username);
        if (admin.isPresent() && passwordEncoder.matches(password, admin.get().getPassword())) {
            logger.info("Admin authenticated successfully.");
            return jwtUtil.generateToken(username);
        } else {
            logger.warn("Authentication failed for admin: {}", username);
            return null;
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Admin not found: " + username));
        return new org.springframework.security.core.userdetails.User(admin.getUsername(), admin.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(admin.getRole())));
    }
}
