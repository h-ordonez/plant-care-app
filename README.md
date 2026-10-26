# Houseplant Care App

A Java web application that lets users search for houseplants and view care instructions  
including watering frequency, sunlight requirements, and plant descriptions.

## Tech Stack

- **Backend:** Java 17, Spring Boot 3, Spring MVC
- **Templating:** Thymeleaf
- **Database:** MySQL 8, Spring Data JPA (Hibernate)
- **Build:** Apache Maven
- **Security:** Spring Security (form login, role-based access, BCrypt)

## Features

- Search for plants by name (partial and case-insensitive)
- Browse all available plants in a card grid
- View care details for each plant: watering schedule, sunlight needs, and a description
- Login and logout with users stored in MySQL (passwords hashed with BCrypt)
- Role-based access: `USER` can browse and search, `ADMIN` can also add, edit, and delete plants


![Browse Plants](screenshots/browse_page.JPG)

## Prerequisites

- JDK 17 or higher
- Apache Maven
- MySQL 8

## Setup

**1. Clone the repository**
  ```
  git clone https://github.com/h-ordonez/plant-care-app.git
  cd plant-care-app
  ```

**2. Configure database credentials**
  ```
  cp PlantCareApp/src/main/resources/application.properties.example \
     PlantCareApp/src/main/resources/application.properties
  ```
Open `application.properties` and fill in your MySQL username and password.

**3. Import the database**

In MySQL, run both scripts from the `sql/` folder, in order. The first creates and populates
`plants_db`; the second creates the login tables and demo users:
  ```
  mysql -u root -p < sql/01_plants_db_20200731.sql
  mysql -u root -p < sql/02_spring_sec_users.sql
  ```

**4. Build and run**
  ```
  cd PlantCareApp
  mvn spring-boot:run
  ```

Then navigate to the following in your web browser:
  ```
  http://localhost:8080/
  ```

## Demo Accounts

These are throwaway accounts for local testing only.

| Username | Password      | Access                                  |
|----------|---------------|-----------------------------------------|
| `user`   | `user123!@#`  | Browse and search plants                |
| `admin`  | `admin123!@#` | Everything above, plus add/edit/delete  |

## Project Structure

  ```
  PlantCareApp/
  ├── src/main/
  │   ├── java/com/plantcareapp/
  │   │   ├── model/Plant.java                # JPA entity mapped to the plants table in DB
  │   │   ├── config/SecurityConfig.java      # Spring Security setup (login, roles)
  │   │   ├── controller/PlantController.java # Spring MVC controller
  │   │   ├── repository/PlantRepository.java # Spring Data JPA repository
  │   │   └── PlantCareAppApplication.java    # Spring Boot entry point
  │   └── resources/
  │       ├── static/
  │       │   ├── Images/
  │       │   └── styles.css
  │       ├── templates/
  │       │   ├── fragments/nav.html
  │       │   ├── about.html
  │       │   ├── access-denied.html
  │       │   ├── contact.html
  │       │   ├── index.html                  # Home page
  │       │   ├── login.html
  │       │   ├── missing-plant.html
  │       │   ├── output.html                 # Plant details page
  │       │   ├── plant-form.html             # Add/Edit plant form
  │       │   ├── plants.html                 # Browse all plants
  │       │   └── search.html
  │       └── application.properties.example  # Database config template
  ├── sql/
  │   ├── 01_plants_db_20200731.sql           # Plant data
  │   └── 02_spring_sec_users.sql             # Login tables and demo users
  └── pom.xml
  ```

