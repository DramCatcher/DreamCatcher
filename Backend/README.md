# DreamCatcher Backend

Spring Boot backend for the DreamCatcher app – used to manage dreams including image uploads.

## Requirements

- Java 17 or higher  
- Maven  
- MariaDB (locally or via Docker)

## Local Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/DramCatcher/DreamCatcher
   cd DreamCatcher/Backend
   ```

2. Create a `.env` file (based on `.env.example`) and add your database credentials.

3. (Optional) Start MariaDB with Docker:

   ```bash
   docker-compose up -d
   ```

4. Set up the database manually for development:

   - Database name: `dreamcatcher_db`
   - You must create the table manually (e.g. in MySQL Workbench):

     ```sql
     CREATE TABLE dream (
       id INT AUTO_INCREMENT PRIMARY KEY,
       title VARCHAR(255) NOT NULL,
       content TEXT NOT NULL,
       timestamp DATETIME NOT NULL,
       img MEDIUMBLOB
     );
     ```

5. Start the application:

   ```bash
   mvn spring-boot:run
   ```

## API Documentation

After starting, the Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

