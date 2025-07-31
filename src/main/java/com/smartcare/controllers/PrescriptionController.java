package com.smartcare.controllers;

import com.smartcare.models.Prescription;
import com.smartcare.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping("/appointment/{appointmentId}")
    public ResponseEntity<Prescription> createPrescription(@PathVariable Long appointmentId, @RequestBody Prescription prescription, Principal principal) {
        prescription.setAppointmentId(appointmentId);
        Prescription savedPrescription = prescriptionService.savePrescription(prescription);
        return ResponseEntity.ok(savedPrescription);
    }
}