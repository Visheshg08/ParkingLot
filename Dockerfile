# 1. Use Java 17 base image
FROM eclipse-temurin:17-jdk

# 2. Set working directory inside the container
WORKDIR /app

# 3. Copy the built JAR from Gradle output
COPY build/libs/*.jar app.jar

# 4. Expose port Spring Boot runs on
EXPOSE 8080

# 5. Command to run your Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]