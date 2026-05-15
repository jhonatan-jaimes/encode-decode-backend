# =========================
# BUILD STAGE
# =========================
FROM ghcr.io/graalvm/native-image-community:21 AS builder

WORKDIR /app

# Copiar archivos del proyecto
COPY . .

# Dar permisos al wrapper
RUN chmod +x mvnw

# Compilar Native Image
RUN ./mvnw -Pnative native:compile -DskipTests

# =========================
# RUNTIME STAGE
# =========================
FROM debian:bookworm-slim

WORKDIR /app

# Instalar certificados SSL
RUN apt-get update && \
    apt-get install -y ca-certificates && \
    rm -rf /var/lib/apt/lists/*

# Copiar ejecutable nativo
COPY --from=builder /app/target/encode-decode ./app

# Puerto usado por Cloud Run
EXPOSE 8080

# Ejecutar aplicación
CMD ["./app"]