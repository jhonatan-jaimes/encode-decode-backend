# Etapa 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Runtime - CAMBIA a JRE (más liviano)
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app
COPY --from=build /app/target/*SNAPSHOT.jar app.jar

# Variables de entorno PARA CLOUD RUN
ENV PORT=8080
ENV JAVA_OPTS="-Xmx256m -Xms128m"

# Exponer el puerto (sí es necesario para Cloud Run)
EXPOSE 8080

# Comando CORREGIDO para usar la variable PORT
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dserver.port=${PORT} -jar app.jar"]