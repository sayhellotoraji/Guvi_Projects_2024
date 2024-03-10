# Guvi_Projects_2024

Mini project 2: Doctor - Patient - Appointment System


By	: Rajasekar T

Batch 	: JFSWD2



# Doctor - Patient - Appointment System
### Developed By Rajasekar T

A Portal for formal interactions between Doctor & Patient is developed using Spring boot. Patients can book appointments while Doctors can issue prescriptions after checkup. 

## Source Code:

### Backend: 

https://github.com/sayhellotoraji/Guvi_Projects_2024/tree/main/Mini_Project_2/doctor_patient_portal

### Frontend: 

https://github.com/sayhellotoraji/Guvi_Projects_2024/tree/main/Mini_Project_2/doctor_patient_portal/src/main/resources/templates

### Views & Outputs: 

https://github.com/sayhellotoraji/Guvi_Projects_2024/tree/main/Mini_Project_2/Views%20%26%20Output%20Images


## Features Developed:

* Registration of Patients page developed using Bootstrap

* Patient side features: Appointment booking, Viewing prescriptions, doctor details & medical history   

* Doctor side features: Appointment cancel, Issue & Modify prescriptions, view patient' s medical history

* Implemented Controllers using Spring Data Rest Dependency, Repository (JPA), Model Layers.

* Designed database and created table.

* Tested the application with Mockito & JUnit.

* Added Security features to the application with Spring Security.

* Used Swagger to document and test REST Api Endpoints.
 

## Technologies Used

* Java Version 17 or Higher
* Maven Build Tool
* Spring boot
* MySQL
* HTML, CSS, JavaScript
* Thymeleaf - Server Side Rendering


## Tools Used

* STS IDE - Backend Application Development
* MySQL Workbench - Database Design & Development
* Postman - API Testing


## System Architecture

### Followed - Monolithic Principle 

Server Side Rendering using Thymeleaf (HTML, CSS, JavaScript)

Backend  - Springboot ( MVC ), JPA, MySQL


## Project Structure

### STS IDE: 
* src/main/java : 

controllers, repositories, models 

* src/main/resources :

application.properties, 

doctor_patient_db.sql

* src/test : JUnit & mockito tests


## Setup 

### Springboot Setup:
* Import the doctor_patient_portal project into the STS IDE

* Right click POM.xml and Select Maven/Update Project or Run mvn install - All the necessary dependencies mentioned in the POM.xml gets downloaded locally 

### MySQL Setup:

* Create schema -> Doctor_Patient_DB in MySQL Workbench

* Run doctor_patient_db.sql - To create the doctor, patient, appointment, prescription, medical_history table & to insert dummy records

* Setup the datasource configuration in application.properties to establish the connection between springboot and mysql


## Configuration 

* In application.properties:

1. Configure Port Number:
server.port = 8082

2. Mysql connection url: 
spring.datasource.url= jdbc:mysql://127.0.0.1:3306/Doctor_Patient_DB



## Run Project

### Backend Application startup:

After successfully setting up the project, Navigate to the project root directory & select the main Spring boot application class file and click on Run button in STS to start the application

The application after successful build, gets hosted locally in localhost:8082


## Important Application URLs: Local

### Backend:
* Swagger RestApi Endpoints Documentation 

http://localhost:8082/swagger-ui/index.html#/ 

* Application Startup login page:

http://localhost:8082/login

* New Patient Registration:
http://localhost:8082/patient/register


* Credentials for Testing Purpose:

Doctor:

    Username: mahalakshmi@gmail.com

    Password: mahauniv


Patient:

    Username: rajasekar@gmail.com

    Password: JFSWD2


## Thank you
## By, Rajasekar T
