-- An example BCrypt hash for the password 'adminpass'.
SET @hashed_password = '$2a$10$8.UnVuG9HHgffUDAlk8qfeclM3pTjZ1iM34ACAYC92Q9g9UcoEdei';

-- Create an ADMIN user with a hashed password
INSERT INTO users (username, password, email, role) 
VALUES ('admin', @hashed_password, 'admin@smartcare.com', 'ADMIN');

-- Create a DOCTOR user with a hashed password
INSERT INTO users (username, password, email, role) 
VALUES ('dr.strange', @hashed_password, 'strange@smartcare.com', 'DOCTOR');

-- Get the user_id of the doctor we just created
SET @doctor_user_id = LAST_INSERT_ID();

-- Then, insert into doctors table
INSERT INTO doctors (user_id, first_name, last_name, specialty) 
VALUES (@doctor_user_id, 'Stephen', 'Strange', 'Neurosurgery');


-- Create a PATIENT user with a hashed password
INSERT INTO users (username, password, email, role) 
VALUES ('tony.stark', @hashed_password, 'tony@stark.com', 'PATIENT');

-- Get the user_id of the patient we just created
SET @patient_user_id = LAST_INSERT_ID();

-- Then, insert into patients table
INSERT INTO patients (user_id, first_name, last_name, date_of_birth, contact_number) 
VALUES (@patient_user_id, 'Tony', 'Stark', '1970-05-29', '555-0100');


-- Schedule an appointment between Dr. Strange and Tony Stark
-- Get the doctor_id and patient_id from their respective tables
SET @doctor_id = (SELECT id FROM doctors WHERE user_id = @doctor_user_id);
SET @patient_id = (SELECT id FROM patients WHERE user_id = @patient_user_id);

-- Insert the appointment
INSERT INTO appointments (doctor_id, patient_id, appointment_date, status, reason)
VALUES (@doctor_id, @patient_id, '2025-08-15 10:30:00', 'SCHEDULED', 'Routine Checkup');