DELIMITER $$

CREATE PROCEDURE GetDoctorAppointments(IN doc_id INT)
BEGIN
    SELECT 
        a.id AS appointment_id,
        a.appointment_date,
        a.status,
        a.reason,
        p.first_name AS patient_first_name,
        p.last_name AS patient_last_name
    FROM 
        appointments a
    JOIN 
        patients p ON a.patient_id = p.id
    WHERE 
        a.doctor_id = doc_id
    ORDER BY 
        a.appointment_date;
END$$

DELIMITER ;