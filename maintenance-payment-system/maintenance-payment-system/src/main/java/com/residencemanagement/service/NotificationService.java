package com.residencemanagement.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendPaymentNotification(String residentId, double amount) {
        // Logic to send email or system notification
        System.out.println("Payment notification sent to resident: " + residentId + ", Amount: $" + amount);
    }
}
