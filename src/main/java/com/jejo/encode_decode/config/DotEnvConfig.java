package com.jejo.encode_decode.config;

import io.github.cdimascio.dotenv.Dotenv;

public class DotEnvConfig {
    public static void dotenv(){
        Dotenv dotenv = Dotenv.load();
        System.setProperty("MYSQL_URI", dotenv.get("MYSQL_URI"));
        System.setProperty("MYSQL_USER", dotenv.get("MYSQL_USER"));
        System.setProperty("MYSQL_PASS", dotenv.get("MYSQL_PASS"));

        System.setProperty("ALLOWED_ORIGINS", dotenv.get("ALLOWED_ORIGINS"));
    }
}
