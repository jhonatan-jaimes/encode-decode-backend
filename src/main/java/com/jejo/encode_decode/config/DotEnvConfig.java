package com.jejo.encode_decode.config;

import io.github.cdimascio.dotenv.Dotenv;

public class DotEnvConfig {
    public static void dotenv() {
        Dotenv dotenv = null;

        try {
            // Intentar cargar .env (solo local)
            dotenv = Dotenv.load();
            System.out.println("✅ Archivo .env cargado correctamente");
        } catch (Exception e) {
            System.out.println("⚠️ No se encontró archivo .env, usando variables del entorno del sistema (producción)");
        }

        // En producción, Cloud Run ya tiene estas variables configuradas
        setIfPresent("MYSQL_URI", getEnv("MYSQL_URI", dotenv));
        setIfPresent("MYSQL_USER", getEnv("MYSQL_USER", dotenv));
        setIfPresent("MYSQL_PASS", getEnv("MYSQL_PASS", dotenv));
        setIfPresent("ALLOWED_ORIGINS", getEnv("ALLOWED_ORIGINS", dotenv));
    }

    private static String getEnv(String key, Dotenv dotenv) {
        if (dotenv != null && dotenv.get(key) != null) {
            return dotenv.get(key);
        }
        return System.getenv(key); // Cloud Run las tiene aquí
    }

    private static void setIfPresent(String key, String value) {
        if (value != null) {
            System.setProperty(key, value);
            System.out.println("✅ Variable cargada: " + key);
        } else {
            System.out.println("⚠️ Variable " + key + " no encontrada. Verifica que esté definida en Cloud Run.");
        }
    }
}
