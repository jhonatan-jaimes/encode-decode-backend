package com.jejo.encode_decode;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncodeDecodeApplication {

	public static void main(String[] args) {

		/*
		* Se utiliza DOTENV para poder configurar a medida de usuario el servidor, se debe crear un ".env"
		* y se encarga de mapear.
		* */
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASS", dotenv.get("DB_PASS"));

		SpringApplication.run(EncodeDecodeApplication.class, args);
	}


}
