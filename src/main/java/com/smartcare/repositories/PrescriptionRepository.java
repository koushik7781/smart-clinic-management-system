package com.smartcare.repositories;

import com.smartcare.models.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrescriptionRepository extends MongoRepository<Prescription, String> {
    // You can add custom find methods here if needed, e.g., findByPatientId
}