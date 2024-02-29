
SHOW schemas;
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
insert into patient(patient_name, dob, sex, mobile_no, address, email, login_password) 
values('Rajasekar T', '1996-11-03', 'Male', '9999999999', '136J1, Tiruvannamalai, Tamil Nadu','rajasekar@gmail.com',  'JFSWD2');

# DQL - Read All Records from the entity
select * from patient;

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
insert into medical_history(history_patient_id, diagnosis_date, medical_condition)
values(1, '2021-08-10', 'Pelvic Fracture');

# DQL - Read All Records from the entity
select * from medical_history;

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
insert into doctor(doctor_name, dob, specialization, sex, mobile_no, address, email, login_password) 
values('Mahalakshmi T', '1998-12-11','Orthopedics','Female', '6666666666', '136J1, Tiruvannamalai, Tamil Nadu','mahalakshmi@gmail.com',  'mahauniv');

# DQL - Read All Records from the entity
select * from doctor;

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
	availability BOOLEAN,
	CONSTRAINT slot_ck CHECK(slot BETWEEN 1 and 24),
#     CONSTRAINT availability_ck CHECK(availability <> TRUE),
    PRIMARY KEY (appointment_id),
    FOREIGN KEY (appointment_doctor_id)
        REFERENCES doctor (doctor_id),
    FOREIGN KEY (appointment_patient_id)
        REFERENCES patient (patient_id)
);

INSERT INTO appointment(appointment_doctor_id, appointment_patient_id, visit_date, slot, availability)
VALUES(1, 1, '2024-02-24', 1, TRUE);

# Checking for available slots
select visit_date, slot from appointment where availability=TRUE;

select * from appointment;
