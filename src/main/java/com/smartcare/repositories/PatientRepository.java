package com.smartcare.repositories;

import com.smartcare.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Method to retrieve by email (via the user object)
    Optional<Patient> findByUserEmail(String email);

    // Method to retrieve by email or phone number
    Optional<Patient> findByUserEmailOrContactNumber(String email, String contactNumber);
}