# 1. Базовий образ з JDK 25
FROM eclipse-temurin:25-jdk

# 2. Встановлюємо робочу директорію
WORKDIR /app

# 3. Копіюємо pom.xml і завантажуємо залежності (для кешування)
COPY pom.xml .
RUN mvn dependency:go-offline

# 4. Копіюємо весь проєкт
COPY src ./src

# 5. Збираємо JAR
RUN mvn clean package -DskipTests

# 6. Вказуємо порт додатку
EXPOSE 8080

# 7. Команда запуску
CMD ["java", "-jar", "target/bugtracker-0.0.1-SNAPSHOT.jar"]
