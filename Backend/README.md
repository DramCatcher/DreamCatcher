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

2. Die Datenbankanmeldedaten sind bereits in der `application.yml` konfiguriert.

3. (Optional) Start MariaDB with Docker:

   ```bash
   docker-compose up -d
   ```

4. Configure database:

   - Database name: `dreamcatcher_db`
   - No manual SQL is required - Hibernate will create the tables automatically using JPA's `ddl-auto: update` configuration

5. Start the application:

   ```bash
   mvn spring-boot:run
   ```

## API Documentation

After starting, the Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

