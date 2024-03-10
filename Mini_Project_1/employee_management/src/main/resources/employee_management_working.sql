
SHOW schemas;
USE Employee_Management;

# 1. Employee Table
# Employee id can also be generated like WT977 instead of just integers 

# DDL - Creation of Entity
CREATE TABLE employee (
    employee_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(24) NOT NULL,
    middle_name VARCHAR(24),
    last_name VARCHAR(24) NOT NULL,
    dob DATE NOT NULL,
    sex VARCHAR(10) NOT NULL,
    mobile_no CHAR(10) NOT NULL,
    email VARCHAR(50) NOT NULL,
    address VARCHAR(100) NOT NULL,
    doj DATE NOT NULL,
    department_name VARCHAR(16) NOT NULL,
    salary DECIMAL(10 , 2 ),
    PRIMARY KEY (employee_id)
);


# DML - Insertion of Records
insert into employee(first_name, middle_name, last_name, dob, sex, mobile_no, email, address, doj, department_name, salary) values('Raja','Sekar','T', '1996-11-03', 'Male', '9999999999', 'rajasekar@gmail.com', '136J1, Tiruvannamalai, Tamil Nadu',  '2021-3-10', 'Development', 1200000);

# Rajasekar T - output
# DQL - Read All Records from the entity
select * from employee;

