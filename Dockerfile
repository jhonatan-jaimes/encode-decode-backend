# Etapa 1: Build con Maven
FROM maven:3.9.8-eclipse-temurin-17 AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

# Cloud Run asigna el puerto dinámicamente, pero se comunica por 8080
ENV PORT=8080
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
