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
		System.setProperty("MYSQL_ADDON_URI", dotenv.get("MYSQL_ADDON_URI"));
		System.setProperty("MYSQL_ADDON_USER", dotenv.get("MYSQL_ADDON_USER"));
		System.setProperty("MYSQL_ADDON_PASS", dotenv.get("MYSQL_ADDON_PASS"));

        System.setProperty("CORS_ALLOWED_ORIGINS", dotenv.get("CORS_ALLOWED_ORIGINS"));

		SpringApplication.run(EncodeDecodeApplication.class, args);
	}


}
