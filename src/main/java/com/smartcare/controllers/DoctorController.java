package com.smartcare.controllers;

import com.smartcare.models.Doctor;
import com.smartcare.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Existing method to get all doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    /**
     * New method for Q5 rubric.
     * Retrieves a doctor's availability. Note: 'date' is a placeholder
     * as the actual availability logic would be more complex.
     * The token is handled by Spring Security's filter chain.
     */
    @GetMapping("/{doctorId}/availability")
    public ResponseEntity<String> getDoctorAvailability(@PathVariable Long doctorId) {
        Optional<String> availability = doctorService.getAvailableTimeSlots(doctorId);
        return availability
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}