package com.smartcare.services;

import com.smartcare.models.Prescription;
import com.smartcare.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription savePrescription(Prescription prescription) {
        // Add any business logic here, e.g., setting the issue date
        return prescriptionRepository.save(prescription);
    }
}