# Registration Form with Spring Boot & Thymeleaf Template

## Project Overview
- This is a group project of 2nd year students for the OOP module CSCI 22082.
- This project aims to build a Signup & Signin form using Spring Boot.
- Hibernate Framework as ORM.
- Thymeleaf for frontend.
- Bootstrap for Styling.
- MySQL as Database.

## Project Requirements
- **JDK version**: 22
- **Java version**: 17
- **Project Builder**: Maven

## Dependencies
- `spring-boot-starter-web`: To build web applications.
- `spring-boot-starter-thymeleaf`: To use the Thymeleaf template engine.
- `spring-boot-starter-data-jpa`: To use Spring Data JPA with Hibernate.
- `spring-boot-devtools`: To provide development tools.
- `mysql-connector-java`: To connect with MySQL database.
- `lombok`: To reduce boilerplate code with annotations.

## Installation and Setup
1. **Clone the repository:**
   ```bash
   git clone https://github.com/chandima2000/registration-form-spring-boot.git
2. **Open XAMPP and Run Apache & MySql:**
   - Open your browser and go to `http://localhost:/phpmyadmin`
   - Select your Database
4. **Set up MySQL Database:**
   - Update the application.properties file with your MySQL credentials.
     - `spring.datasource.url=jdbc:mysql://localhost:<YOUR_MySQL_PORT>/<YOUR_DB_NAME>?createDatabaseIfNotExist=true`
     - `spring.datasource.username=<YOUR_USERNAME>`
     - `spring.datasource.password=<YOUR_PASSWORD>`
     - `spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`
5. **Build & Run the Project**
6. **Access the Application:**
   - Open your browser and go to `http://localhost:8080/signup`
  
## Contributors
Thanks go to these wonderful people.
- Chandima (CS/2020/020): Project coordinator, Setting up the development environment, initial project setup & final validation check. 
- Hansani (CS/2020/021): Signup backend development, and database integration.
- Supuni (CS/2020/026): Signup frontend development and form validation.
- Piyumi (CS/2020/024): Login backend development, and database integration.
- Ransika (CS/2020/058): Login frontend development and form validation.
- Kavindi (CS/2020/023): Dashboard development and Login backend development 


   

