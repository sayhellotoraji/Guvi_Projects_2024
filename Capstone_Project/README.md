# Guvi_Projects_2024

Capstone Project: Online Bus Ticket Booking System


By	: Rajasekar T

Batch 	: JFSWD2



# Online Bus Ticket Booking System
### Developed By Rajasekar T

A Portal to browse bus schedules, check availability of seats in the bus and book them online. 

## Source Code:

### Backend: 

https://github.com/sayhellotoraji/Guvi_Projects_2024/tree/main/Capstone_Project/bus_ticket_booking


### Frontend: 

https://github.com/sayhellotoraji/Guvi_Projects_2024/tree/main/Capstone_Project/bus_ticket_booking/src/main/resources/templates

### Views & Outputs: 

https://github.com/sayhellotoraji/Guvi_Projects_2024/tree/main/Capstone_Project/Views%20%26%20Output%20Images



## Features Developed:

* Registration of Passengers page developed using Bootstrap

* Passengers can view multiple bus schedules, book new tickets & view their previous bookings and also browse buses based on date and from-to location.

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

bus_ticket_booking.sql

* src/test : JUnit & mockito tests


## Setup 

### Springboot Setup:
* Import the bus_ticket_booking project into the STS IDE

* Right click POM.xml and Select Maven/Update Project or Run mvn install - All the necessary dependencies mentioned in the POM.xml gets downloaded locally 

### MySQL Setup:

* Create schema -> Bus_Ticket_Booking in MySQL Workbench

* Run bus_ticket_booking.sql - To create the Passenger, bus & booking table & to insert dummy records

* Setup the datasource configuration in application.properties to establish the connection between springboot and mysql


## Configuration 

* In application.properties:

1. Configure Port Number:
server.port = 8083

2. Mysql connection url: 
spring.datasource.url= jdbc:mysql://127.0.0.1:3306/Bus_Ticket_Booking



## Run Project

### Backend Application startup:

After successfully setting up the project, Navigate to the project root directory & select the main Spring boot application class file and click on Run button in STS to start the application

The application after successful build, gets hosted locally in localhost:8083


## Important Application URLs: Local

### Backend:
* Swagger RestApi Endpoints Documentation 

http://localhost:8083/swagger-ui/index.html#/ 

* Application Startup login page:

http://localhost:8083/login

* New Passenger Registration:

http://localhost:8083/passenger/register


* Credentials for Testing Purpose:

Passenger:

    Username: raj@outlook.com

    Password: JFSWD2


## Thank you
## By, Rajasekar T
