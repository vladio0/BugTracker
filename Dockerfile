# ---- Build stage ----
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Копіюємо pom.xml і кешуємо залежності
COPY pom.xml .
RUN mvn dependency:go-offline

# Копіюємо весь код
COPY src ./src

# Збираємо JAR
RUN mvn clean package -DskipTests

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app

# Копіюємо зібраний JAR
COPY --from=build /app/target/bugtracker-0.0.1-SNAPSHOT.jar ./app.jar

# Вказуємо порт
EXPOSE 8080

# Команда запуску
CMD ["java", "-jar", "app.jar"]
