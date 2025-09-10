package com.jejo.encode_decode.config;

import io.github.cdimascio.dotenv.Dotenv;

public class DotEnvConfig {
    public static void dotenv() {
        Dotenv dotenv = null;

        try {
            // Intenta cargar el archivo .env (solo funcionará en local)
            dotenv = Dotenv.load();
        } catch (Exception e) {
            System.out.println("⚠️ No se encontró archivo .env, usando variables de entorno del sistema");
        }

        // MYSQL
        System.setProperty("MYSQL_URI", getEnv("MYSQL_URI", dotenv));
        System.setProperty("MYSQL_USER", getEnv("MYSQL_USER", dotenv));
        System.setProperty("MYSQL_PASS", getEnv("MYSQL_PASS", dotenv));

        // CORS
        System.setProperty("ALLOWED_ORIGINS", getEnv("ALLOWED_ORIGINS", dotenv));
    }

    private static String getEnv(String key, Dotenv dotenv) {
        if (dotenv != null && dotenv.get(key) != null) {
            return dotenv.get(key);
        }
        return System.getenv(key); // usa variables de entorno si no hay .env
    }
}
