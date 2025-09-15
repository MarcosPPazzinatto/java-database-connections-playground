## Overview

This repository serves as a training ground for learning and comparing different database connection methods in Java. It provides minimal, runnable examples for PostgreSQL and MongoDB.

## Features

- PostgreSQL with plain JDBC and HikariCP
- PostgreSQL with Spring Boot and Spring Data JPA
- MongoDB with the synchronous driver
- MongoDB with Spring Boot and Reactive Streams

## Prerequisites

- Java 21 (Java 17 LTS also works)
- Gradle 8.x
- Docker and Docker Compose

## Quick Start

1. Clone the repository:
```
git clone https://github.com/your-org/java-database-connections-playground.git
cd java-database-connections-playground
```
2. Copy environment variables:
```
cp .env.example .env
```
3. Start the databases:
```
docker compose up -d
```
4. Build the project:
```
./gradlew clean build
```
5. Run one of the sample modules (examples):
```
./gradlew :modules:postgres-jdbc:run
./gradlew :modules:postgres-jpa:bootRun
./gradlew :modules:mongo-sync:run
./gradlew :modules:mongo-reactive:bootRun
```

## Next Steps

- Add automated tests using Testcontainers
- Integrate database migrations with Flyway
- Add simple REST endpoints for CRUD
- Configure CI/CD with GitHub Actions

## License

MIT
