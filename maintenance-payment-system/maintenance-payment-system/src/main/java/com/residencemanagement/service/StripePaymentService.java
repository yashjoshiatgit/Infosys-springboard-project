package com.residencemanagement.service;

import com.residencemanagement.dto.PaymentRequestDTO;
import com.residencemanagement.model.PaymentTransaction;
import com.residencemanagement.repository.PaymentTransactionRepository;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripePaymentService {

    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;

    public String processPayment(PaymentRequestDTO request) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("amount", (int) (request.getAmount() * 100)); // Amount in cents
            params.put("currency", "usd");
            params.put("payment_method_types", new String[]{"card"});

            PaymentIntent paymentIntent = PaymentIntent.create(params);

            PaymentTransaction transaction = new PaymentTransaction();
            transaction.setBillId(request.getBillId());
            transaction.setAmountPaid(request.getAmount());
            transaction.setPaymentDate(new Date());
            transaction.setPaymentMethod("Stripe");
            paymentTransactionRepository.save(transaction);

            return "Payment Successful with ID: " + paymentIntent.getId();
        } catch (StripeException e) {
            return "Payment Failed: " + e.getMessage();
        }
    }
}
