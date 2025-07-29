package com.smartcare.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Future(message = "Appointment date must be in the future")
    @NotNull
    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AppointmentStatus status;

    private String reason;

    public enum AppointmentStatus { SCHEDULED, COMPLETED, CANCELED }

    // Getters and Setters will be added later
}