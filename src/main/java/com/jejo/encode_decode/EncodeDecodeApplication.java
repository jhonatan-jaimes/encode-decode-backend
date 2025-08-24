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
		System.setProperty("MYSQL_URI", dotenv.get("MYSQL_URI"));
		System.setProperty("MYSQL_USER", dotenv.get("MYSQL_USER"));
		System.setProperty("MYSQL_PASS", dotenv.get("MYSQL_PASS"));

        System.setProperty("ALLOWED_ORIGINS", dotenv.get("ALLOWED_ORIGINS"));

		SpringApplication.run(EncodeDecodeApplication.class, args);
	}


}
