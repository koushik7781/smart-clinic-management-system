package com.smartcare.controllers;

import com.smartcare.models.Doctor;
import com.smartcare.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Modify the existing method to return ResponseEntity
@GetMapping
public ResponseEntity<List<Doctor>> getAllDoctors() {
    List<Doctor> doctors = doctorService.getAllDoctors();
    return ResponseEntity.ok(doctors);
}
}