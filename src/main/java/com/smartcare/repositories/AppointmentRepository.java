package com.smartcare.repositories;

import com.smartcare.models.Appointment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // You can add custom query methods here later
    List<Appointment> findByDoctorId(Long doctorId);
}