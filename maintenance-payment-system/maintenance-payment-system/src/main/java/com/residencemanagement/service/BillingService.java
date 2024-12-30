package com.residencemanagement.service;

import com.residencemanagement.dto.BillSummaryDTO;
import com.residencemanagement.model.MaintenanceBill;
import com.residencemanagement.model.Resident;
import com.residencemanagement.repository.MaintenanceBillRepository;
import com.residencemanagement.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillingService {

    @Autowired
    private MaintenanceBillRepository billRepository;

    @Autowired
    private ResidentRepository residentRepository;

    public void generateMonthlyBills() {
        List<Resident> residents = residentRepository.findAll();

        for (Resident resident : residents) {
            MaintenanceBill bill = new MaintenanceBill();
            bill.setResidentId(resident.getId());
            bill.setAmount(100.00); // Monthly fixed maintenance amount
            bill.setDueDate(new Date(System.currentTimeMillis() + 7L * 24 * 60 * 60 * 1000)); // 7 days due
            bill.setPaid(false);
            billRepository.save(bill);
        }
    }

    public BillSummaryDTO getBillSummary(String residentId) {
        List<MaintenanceBill> bills = billRepository.findAll();

        double totalAmount = bills.stream()
                .filter(bill -> bill.getResidentId().equals(residentId))
                .mapToDouble(MaintenanceBill::getAmount)
                .sum();

        boolean isPaid = bills.stream()
                .anyMatch(bill -> bill.getResidentId().equals(residentId) && bill.isPaid());

        Resident resident = residentRepository.findById(residentId).orElse(null);

        BillSummaryDTO summary = new BillSummaryDTO();
        summary.setResidentName(resident != null ? resident.getName() : "Unknown");
        summary.setTotalAmount(totalAmount);
        summary.setPaid(isPaid);
        return summary;
    }

    public List<MaintenanceBill> getPendingPayments() {
        return billRepository.findAll().stream()
                .filter(bill -> !bill.isPaid())
                .collect(Collectors.toList());
    }
}
