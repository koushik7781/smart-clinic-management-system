package com.smartcare.repositories;

import com.smartcare.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional; // Make sure this import exists

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // Add this line
    Optional<Doctor> findByUserUsername(String username);
}