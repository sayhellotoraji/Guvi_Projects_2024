
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
insert into patient(patient_name, dob, sex, mobile_no, address, email,login_password) 
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