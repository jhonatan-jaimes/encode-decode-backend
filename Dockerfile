# Etapa 1: Compilar el proyecto
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar dependencias primero (mejor uso del caché)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar código fuente y compilar
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen ligera para ejecución
FROM eclipse-temurin:17-jdk-alpine

# Cloud Run asigna el puerto mediante variable PORT
ENV PORT=8080
WORKDIR /app

# Copiar el .jar generado
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto (solo informativo)
EXPOSE 8080

# Comando de inicio
CMD ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]
