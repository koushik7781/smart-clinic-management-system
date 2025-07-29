-- Sample data for the Smart Clinic Management System

-- Create an ADMIN user
INSERT INTO users (username, password, email, role) 
VALUES ('admin', 'adminpass', 'admin@smartcare.com', 'ADMIN');

-- Create a DOCTOR user and corresponding doctor profile
INSERT INTO users (username, password, email, role) 
VALUES ('dr.strange', 'doctorpass', 'strange@smartcare.com', 'DOCTOR');

SET @doctor_user_id = LAST_INSERT_ID();

INSERT INTO doctors (user_id, first_name, last_name, specialty) 
VALUES (@doctor_user_id, 'Stephen', 'Strange', 'Neurosurgery');

-- Create a PATIENT user and corresponding patient profile
INSERT INTO users (username, password, email, role) 
VALUES ('tony.stark', 'patientpass', 'tony@stark.com', 'PATIENT');

SET @patient_user_id = LAST_INSERT_ID();

INSERT INTO patients (user_id, first_name, last_name, date_of_birth, contact_number) 
VALUES (@patient_user_id, 'Tony', 'Stark', '1970-05-29', '555-0100');

-- Schedule an appointment
SET @doctor_id = (SELECT id FROM doctors WHERE user_id = @doctor_user_id);
SET @patient_id = (SELECT id FROM patients WHERE user_id = @patient_user_id);

INSERT INTO appointments (doctor_id, patient_id, appointment_date, status, reason)
VALUES (@doctor_id, @patient_id, '2025-08-15 10:30:00', 'SCHEDULED', 'Routine Checkup');