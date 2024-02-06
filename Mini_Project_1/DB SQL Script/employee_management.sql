
SHOW schemas;
USE Employee_Management;

# 1. Employee Table
# Employee id can also be generated like WT977 instead of just integers 

# DDL - Creation of Entity
CREATE TABLE Employee (
    employee_id INT,
    first_name VARCHAR(24) NOT NULL,
    middle_name VARCHAR(24),
    last_name VARCHAR(24) NOT NULL,
    dob DATE NOT NULL,
    sex ENUM('Male', 'Female', 'Transgender') NOT NULL,
    mobile_no CHAR(10) NOT NULL,
    email VARCHAR(50) NOT NULL,
    address VARCHAR(100) NOT NULL,
    doj DATE NOT NULL,
    department_name ENUM('Accounts', 'Development', 'DevOPS', 'Testing', 'HR') NOT NULL,
    salary_per_annum DECIMAL(10 , 2 ),
    PRIMARY KEY (employee_id)
);


# DML - Insertion of Records
insert into Employee values(1, 'Raja','Sekar','T', '1996-11-03', 'Male', '9999999999', 'sayhellotoraji@gmail.com', '136J1, Tiruvannamalai, Tamil Nadu',  '2021-3-10', 'Development', 1200000);


# DQL - Read All Records from the entity
select * from Employee;

