FROM maven:4.0.0-eclipse-temurin-25 AS build

WORKDIR /app

# Копіюємо pom.xml і кешуємо залежності
COPY pom.xml .
RUN mvn dependency:go-offline

# Копіюємо весь код
COPY src ./src

# Збираємо JAR
RUN mvn clean package -DskipTests
