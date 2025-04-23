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
http://localhost:8080/api/swagger-ui/index.html
```

## Production Deployment

For production deployment, the application is configured to:

1. Listen on all network interfaces (`0.0.0.0`)
2. Use the `/api` context path
3. Allow CORS requests from `https://dreamcatcher.galister.ch`

To properly integrate with a web server (Apache/Nginx):

1. Configure a reverse proxy to forward requests from `/api/*` to the Spring Boot application
2. The frontend should make API requests to `/api/dreams` instead of directly to `/dreams`

