package com.smartcare.controllers;

import com.smartcare.models.Appointment;
import com.smartcare.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment) {
        // Use the correct method name: bookAppointment
        Appointment savedAppointment = appointmentService.bookAppointment(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        List<Appointment> appointments = appointmentService.findAppointmentsByDoctorId(doctorId);
        return ResponseEntity.ok(appointments);
    }
}