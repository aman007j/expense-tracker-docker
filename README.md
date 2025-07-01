# Expense Tracker Backend

A Spring Boot backend for managing expense entries, users, and roles.

## Features

- User authentication and role-based authorization
- CRUD operations for expense entries
- Category management
- RESTful API endpoints

## Technologies

- Java
- Spring Boot
- Spring Security
- Maven
- JPA/Hibernate

## Project Structure

- `controller/` - REST controllers
- `entity/` - JPA entities
- `repository/` - Spring Data JPA repositories
- `service/` - Business logic
- `config/` - Security and data initialization
- `enums/` - Enum types

## Getting Started

### Prerequisites

- Java 17+
- Maven
- (Optional) MySQL or H2 database

### Setup

1. Clone the repository:
  `https://github.com/aman007j/expense-tracker-docker.git`

3. Configure database in
   `src/main/resources/application.properties`.
4. Build and run:
   `mvn clean install mvn spring-boot:run`

## API Endpoints

- `/api/expenses` - Manage expenses
- `/api/login` - User login
- `/api/test` - Test endpoint

## Docker Support
This project includes Docker and Docker Compose configurations for easy containerized deployment.


Build and Run with Docker
1. Build the Docker image:
   `docker build -t expense-tracker-app`
   
2. Run the application with Docker Compose:
   `docker-compose up`

This will start both the Spring Boot app and a MySQL database container.

### Configuration
Environment variables for database connection are managed in the docker-compose.yml file.
The app listens on port 8080 and the MySQL database on port 3307 (host).

### Files
Dockerfile: Defines the multi-stage build for the Spring Boot application.
docker-compose.yml: Orchestrates the app and database containers.
