# Guvi_Projects_2024

Mini project : 1 - Employee Management System


By	: Rajasekar T

Batch 	: JFSWD2



# Employee Management System
### Developed By Rajasekar T

A CRUD Application for Employee management is developed using Spring boot. 

Source Code:

Backend: https://github.com/sayhellotoraji/Guvi_Projects_2024/tree/main/Mini_Project_1/employee_management

Frontend: https://github.com/sayhellotoraji/Guvi_Projects_2024/tree/main/Mini_Project_1/employee_management_frontend

Views & Outputs: https://github.com/sayhellotoraji/Guvi_Projects_2024/tree/main/Mini_Project_1/Views%20%26%20Output%20Images


Features Developed:

* Developed Add, View, Update & Delete functionality with respect to Employee management

* Implemented Controller, Service, Repository (JPA), Model Layers.

* Designed database and created table.

* Tested the application with Mockito & JUnit.

* Added Security features to the application with Spring Security.

* Global Handling of Exceptions with Controller Advice.

* Used Swagger to document and test REST Api Endpoints.
 

## Technologies Used

* Java Version 17 or Higher
* Maven Build Tool
* Spring boot
* MySQL
* HTML, CSS, JavaScript


## Tools Used

* STS IDE - Backend Application Development
* VS Code - Frontend Application Development
* VS Code extension: Live Server - To locally host webpages
* MySQL Workbench - Database Design & Development
* Postman - API Testing


## System Architecture

### Followed - Separation of Concerns Principle 

Independent working of:

Frontend - HTML, CSS, JavaScript

Backend  - Springboot ( MVC ), JPA, MySQL

* Seamless integration between front and backend with the help of controllers & REST APIs



## Project Structure

STS IDE: Backend
* src/main/java : 
controllers, services, repositories, models 

* src/main/resources :
application.properties, employee_management_working.sql

* src/test : JUnit & mockito tests


VS Code IDE: Frontend

Containts 3 folders
* html - contains index.html
* css 
* js



## Setup 

### Springboot Setup:
* Import the employee_management project into the STS IDE

* Right click POM.xml and Select Maven/Update Project or Run mvn install - All the necessary dependencies mentioned in the POM.xml gets downloaded locally 

### MySQL Setup:

* Create schema -> Employee_Management in MySQL Workbench

* Run employee_management_working.sql - To create the employee table & to insert dummy records

* Setup the datasource configuration in application.properties to establish the connection between springboot and mysql

### VS Code Setup: 

* Open the employee_management_frontend folder in VS Code 



## Configuration 

* In application.properties:

1. Configure Port Number:
server.port = 8081

2. Mysql connection url: 
spring.datasource.url= jdbc:mysql://127.0.0.1:3306/Employee_Management



## Run Project

### Backend Application startup:

After successfully setting up the project, Navigate to the project root directory & select the main Spring boot application class file and click on Run button in STS to start the application

The application after successful build, gets hosted locally in localhost:8081


### Frontend Application startup:

Select the index.html file and click on Live Server, which is a VS Code extension, to host frontend locally


## Important Application URLs: Local

### Backend:
* Swagger RestApi Endpoints Documentation 

http://localhost:8081/swagger-ui/index.html#/ 

* Application Startup login page:

http://localhost:8081/login


* Admin Credentials for Testing Purpose:

    Username: Raja

    Password: JFSWD2

### Frontend:
* Frontend View landing page: index.html

http://127.0.0.1:5500/html/

## Thank you
## By, Rajasekar T
