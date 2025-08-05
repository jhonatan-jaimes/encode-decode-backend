package com.jejo.encode_decode;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncodeDecodeApplication {

	public static void main(String[] args) {
		// Carga el archivo .env
		Dotenv dotenv = Dotenv.load();

		// Establece como variables de sistema para que Spring las use
		System.setProperty("DB_URLB", dotenv.get("DB_URLB"));
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASS", dotenv.get("DB_PASS"));

		SpringApplication.run(EncodeDecodeApplication.class, args);
	}


}
