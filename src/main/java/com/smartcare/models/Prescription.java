package com.smartcare.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "prescriptions")
public class Prescription {

    @Id
    private String id;
    private Long patientId;
    private Long doctorId;
    private Long appointmentId;
    private LocalDateTime issueDate;
    private List<Medication> medications;
    private String generalInstructions;

    public static class Medication {
        private String name;
        private String dosage;
        private String frequency;
        private String notes;

        // Getters and Setters will be added later
    }

    // Getters and Setters will be added later
}