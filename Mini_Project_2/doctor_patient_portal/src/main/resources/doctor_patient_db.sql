
SHOW SCHEMAS;

# Execute the command to shift the current database
USE Doctor_Patient_DB;


# 1. Patient Table

# DROP table patient;

# DDL - Creation of Entity
CREATE TABLE patient (
    patient_id INT NOT NULL AUTO_INCREMENT,
    patient_name VARCHAR(24) NOT NULL,
    dob DATE NOT NULL,
    sex VARCHAR(10) NOT NULL,
    mobile_no CHAR(10) NOT NULL,
    address VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    login_password VARCHAR(24) NOT NULL,
    PRIMARY KEY (patient_id)
);


# DML - Insertion of Records
INSERT INTO patient(patient_name, dob, sex, mobile_no, address, email, login_password) 
VALUES('Rajasekar T', '1996-11-03', 'Male', '9999999999', '136J1, Tiruvannamalai, Tamil Nadu','rajasekar@gmail.com',  'JFSWD2');

# DQL - Read All Records from the entity
SELECT * FROM patient;

#--------------------------------------------------------------------------------
# 2. Medical History

# DROP TABLE medical_history;

# DDL - Creation of Entity
CREATE TABLE medical_history (
    history_id INT NOT NULL AUTO_INCREMENT,
    history_patient_id INT,
    diagnosis_date DATE NOT NULL,
    medical_condition VARCHAR(50),
    PRIMARY KEY (history_id),
    FOREIGN KEY (history_patient_id)
        REFERENCES patient(patient_id)
); 

# DML - Insertion of Records
INSERT INTO medical_history(history_patient_id, diagnosis_date, medical_condition)
VALUES(1, '2021-08-10', 'Pelvic Fracture');

# DQL - Read All Records from the entity
SELECT * FROM medical_history;

#--------------------------------------------------------------------------------

# 3. Doctor

# DROP table Doctor;

# DDL - Creation of Entity
CREATE TABLE doctor (
    doctor_id INT NOT NULL AUTO_INCREMENT,
    doctor_name VARCHAR(24) NOT NULL,
    dob DATE NOT NULL,
    specialization VARCHAR(24) NOT NULL,
    sex VARCHAR(10) NOT NULL,
    mobile_no CHAR(10) NOT NULL,
    address VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    login_password VARCHAR(24) NOT NULL,
    PRIMARY KEY (doctor_id)
);


# DML - Insertion of Records
INSERT INTO doctor(doctor_name, dob, specialization, sex, mobile_no, address, email, login_password) 
VALUES
('Mahalakshmi T', '1998-12-11','Orthopedics','Female', '6666666666', '136J1, Tiruvannamalai, Tamil Nadu','mahalakshmi@gmail.com',  'mahauniv'),
('MohanRaj T', '2000-08-03','HLRS','Male','9999999999','Polur, Tamil Nadu', 'mohan@gmail.com', 'mohanuniv');

# DQL - Read All Records from the entity
SELECT * FROM doctor;

#--------------------------------------------------------------------------------

# 4. Appointment Table

# DROP table appointment;

# DDL - Creation of Entity
# Instead of time - start and end
# Use slots instead - Concise
CREATE TABLE appointment (
    appointment_id INT NOT NULL AUTO_INCREMENT,
    appointment_doctor_id INT,
    appointment_patient_id INT,
    visit_date DATE,
	slot INT,
	booked BOOLEAN DEFAULT TRUE,
	CONSTRAINT slot_ck CHECK(slot BETWEEN 1 AND 24),
#     CONSTRAINT availability_ck CHECK(availability <> TRUE),
    PRIMARY KEY (appointment_id),
    FOREIGN KEY (appointment_doctor_id)
        REFERENCES doctor (doctor_id),
    FOREIGN KEY (appointment_patient_id)
        REFERENCES patient (patient_id)
);

INSERT INTO appointment(appointment_doctor_id, appointment_patient_id, visit_date, slot, booked)
VALUES(1, 1, '2024-02-24', 1, TRUE);

INSERT INTO appointment(appointment_doctor_id, appointment_patient_id, visit_date, slot, booked)
VALUES(1, 1, '2024-02-24', 5, TRUE);

# While booking a slot-> SET booked = true,
# Check for available slots using repository layer method - In Java
SELECT visit_date, slot FROM appointment WHERE booked=TRUE;

SELECT * FROM appointment;


#--------------------------------------------------------------------------------

# 5. Prescription Table

# DROP table prescription;

# DDL - Creation of Entity

CREATE TABLE prescription (
    prescription_id INT NOT NULL AUTO_INCREMENT,
    prescription_doctor_id INT,
    prescription_patient_id INT,
    issued_date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    findings VARCHAR(200),
    # medicines JSON,
    medicines VARCHAR(1000),
    PRIMARY KEY (prescription_id),
    FOREIGN KEY (prescription_doctor_id)
        REFERENCES doctor (doctor_id),
    FOREIGN KEY (prescription_patient_id)
        REFERENCES patient (patient_id)
);

# INSERT INTO prescription(prescription_doctor_id, prescription_patient_id, findings, medicines)
# VALUES(1, 1, 'Cold & Fever', '{"medicines":{"dexilant":
# {"qty":3,"morning": 1, "afternoon":0, "night": 0}}}'); 


INSERT INTO prescription(prescription_doctor_id, prescription_patient_id, findings, medicines)
VALUES(1, 1, 'Cold & Fever', 'Dolo: 1-1-1, Cetrizine: 1-0-1'); 
SELECT * FROM prescription;