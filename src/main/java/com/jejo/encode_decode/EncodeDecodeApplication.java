package com.jejo.encode_decode;

import com.jejo.encode_decode.config.DotEnvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncodeDecodeApplication {

	public static void main(String[] args) {

		/*
		* Se utiliza DOTENV para poder configurar a medida de usuario el servidor, se debe crear un".env"
		* y se encarga de mapear.
		* */
        DotEnvConfig.dotenv(); // <--- Aqui arranca el dotenv (.env) para arrancar la app.

		SpringApplication.run(EncodeDecodeApplication.class, args);
	}
}
