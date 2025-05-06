
# Stage 1: Build the application with Java 21
FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application with Java 21
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/web-based-walller-backend-0.0.1-SNAPSHOT.jar web-based-waller-backend.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "web-based-waller-backend.jar"]