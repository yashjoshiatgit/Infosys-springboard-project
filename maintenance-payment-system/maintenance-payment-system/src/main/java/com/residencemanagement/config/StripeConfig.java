package com.residencemanagement.config;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;

@Configuration
public class StripeConfig {

    @Value("${stripe.api-key}")
    private String stripeApiKey;

    @PostConstruct
    public void init() {
        if (stripeApiKey == null || stripeApiKey.trim().isEmpty()) {
            throw new IllegalStateException("Stripe API key must not be null or empty");
        }
        Stripe.apiKey = stripeApiKey;
    }
}
