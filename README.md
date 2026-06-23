# House Plant Care App

A Java web application that lets users search for houseplants and view care instructions  
including watering frequency, sunlight requirements, and plant descriptions.

## Tech Stack

- **Backend:** Java 11, Servlets (javax.servlet 4.0), JSP, JSTL
- **Database:** MySQL 8
- **Build:** Apache Maven
- **Server:** Apache Tomcat

## Features

- Search for plants by name
- Browse all available plants in a card grid
- View care details for each plant: watering schedule, sunlight needs, and a description


![Browse Plants](screenshots/browse_page.JPG)

## Prerequisites

- JDK 11 or higher
- Apache Maven
- MySQL 8
- Apache Tomcat 9

## Setup

**1. Clone the repository**
  ```                                                                                       
  git clone https://github.com/h-ordonez/plant-care-app.git                                                                
  cd PlantCareApp                                                                           
  ```

**2. Import the database**

In MySQL, run the included dump file to create and populate the `plants_db` database:
  ```                                                                                       
  mysql -u root -p < plants_db_20200731.sql                                                 
  ```                                                                                       

**3. Configure database credentials**
  ```                                                                                       
  cp PlantCareApp/src/main/resources/db.properties.example                                  
  PlantCareApp/src/main/resources/db.properties                                             
  ```                                                                                       
Open `db.properties` and fill in your MySQL username and password.

**4. Build the WAR**
  ```                                                                                       
  cd PlantCareApp                                                                           
  mvn clean package                                                                         
  ```                                                                                       

**5. Deploy to Tomcat**

Copy `target/PlantCareApp-1.0.war` into your Tomcat `webapps/` directory and start Tomcat.
Then navigate to the following in your web browser:
  ```                                                                                       
  http://localhost:8080/PlantCareApp-1.0/                                                   
  ```

## Project Structure

  ```                                                                                       
  PlantCareApp/                                                                             
  ├── src/main/                                                                             
  │   ├── java/                                                                             
  │   │   ├── business/Plant.java              # Plant data model                           
  │   │   ├── controller/                                                                   
  │   │   │   ├── SearchServlet.java           # Handles plant search requests              
  │   │   │   └── PlantListServlet.java        # Handles browse all request                 
  │   │   └── dao/PlantDAO.java               # Database access layer                       
  │   ├── resources/                                                                        
  │   │   └── db.properties.example           # Database config template                    
  │   └── webapp/                                                                           
  │       ├── WEB-INF/web.xml                                                               
  │       ├── Images/                                                                       
  │       ├── index.html                       # Home page with search form                 
  │       ├── plants.jsp                       # Browse all plants                          
  │       ├── output.jsp                       # Plant detail page                          
  │       └── styles.css                                                                    
  ├── plants_db_20200731.sql                   # Database seed file                         
  └── pom.xml                                                                               
  ```

