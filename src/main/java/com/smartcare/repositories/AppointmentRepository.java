package com.smartcare.repositories;

import com.smartcare.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate; // Add this import
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDoctorId(Long doctorId);

    // This method requires the LocalDate import
    List<Appointment> findByDoctorIdAndAppointmentDate(Long doctorId, LocalDate date);
}