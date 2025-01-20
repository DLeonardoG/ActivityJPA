# Airline Management System - NovAir

## Overview
This project is an Airline Management System designed to efficiently manage flight operations, passenger bookings, crew assignments, and maintenance records. The system was implemented using Java with NetBeans IDE, Spring Boot, JPA (Java Persistence API), and integrated with a PostgreSQL database. The UML diagram for the database design was created using StarUML.

---

## Technologies Used
- **NetBeans IDE**: Development environment for Java.
- **Spring Boot**: Framework for building the backend application.
- **JPA**: Used for object-relational mapping (ORM) with the database.
- **PostgreSQL**: Relational database for storing airline data.
- **StarUML**: Tool for designing the UML diagram.

---

## Features
### Database
The database schema is designed to handle the following aspects:
1. **Passengers**:
   - Records passenger details such as name and ID.
   - Tracks booking information via the `tickets` table.

2. **Flights**:
   - Maintains details of flights, including origin, destination, departure, and arrival times.
   - Links planes and crew members to specific flights.

3. **Crew Members**:
   - Stores crew member details, their roles, and flight assignments.

4. **Planes**:
   - Tracks plane models, seating capacity, and maintenance history.

5. **Maintenance**:
   - Logs maintenance records with details on types and associated costs.

6. **Tickets**:
   - Manages ticket purchases, seat classes, and payment methods.

7. **Airports and Locations**:
   - Stores information about airports and their locations.

### Backend
- CRUD operations for managing flights, passengers, crew members, planes, and tickets.
- Integration of JPA for seamless interaction with the database.
- Use of Spring Boot controllers and services for API endpoints.
- Optional feature usage for null-safe queries.

---

## UML Diagram
The UML diagram provides a comprehensive view of the database structure and its relationships. Key components include:

1. **Entity Relationships**:
   - One-to-Many: For example, one flight can have multiple tickets.
   - Many-to-Many: For example, crew members assigned to flights.

2. **Attributes**:
   - Primary and foreign keys for maintaining relationships.
   - Attributes tailored to specific entities, such as `dateExit`, `idPlanes`, `role`, and `payMethod`.

3. **Associative Tables**:
   - Used for many-to-many relationships, such as `flights_crewMembers` and `maintence_typeMaintenance`.

---

## Instructions to Run the Project

1. **Set Up the Database**:
   - Import the PostgreSQL schema from the UML design into your database.
   - Ensure all tables and relationships are created.

2. **Backend Setup**:
   - Clone the project repository.
   - Open the project in NetBeans.
   - Configure application properties in Spring Boot to connect to the PostgreSQL database.
   - Run the Spring Boot application.

3. **Test the Application**:
   - Use Postman or a similar tool to test API endpoints.
   - Perform CRUD operations on entities like flights, passengers, and tickets.

---

## Future Enhancements
- Implement a frontend interface for user interaction.
- Add advanced features like flight search and filtering by date or location.
- Integrate payment gateways for ticket purchases.
- Add reporting tools for analytics on flights, passengers, and maintenance.

---

## Contributors
- **Leonardo Gonzales**
- **Santiago Santacruz**
- **Kevin Romero**







