package com.smartcare.services;

import com.smartcare.models.Doctor;
import com.smartcare.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    
    public Optional<Doctor> validateDoctorLogin(String username, String rawPassword) {
        Optional<Doctor> doctorOpt = doctorRepository.findByUserUsername(username);
        if (doctorOpt.isPresent()) {
            Doctor doctor = doctorOpt.get();
            if (passwordEncoder.matches(rawPassword, doctor.getUser().getPassword())) {
                return Optional.of(doctor);
            }
        }
        return Optional.empty();
    }

    public Optional<String> getAvailableTimeSlots(Long doctorId) {
        // This is the line that was causing the error.
        // The syntax Doctor::getAvailableTimes is a method reference and is correct.
        return doctorRepository.findById(doctorId).map(Doctor::getAvailableTimes);
    }
}