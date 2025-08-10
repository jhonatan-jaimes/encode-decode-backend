package com.jejo.encode_decode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigCors {

    /*
    * Manejo de la configuration del servidor para otorgar permisos a determinadas cuáles páginas
    * pueden consumir estos servicios.
    * */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        // Retorna la configuration del servidor y los permisos que se otorgan.
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "*"
                        )
                        .allowedHeaders("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .maxAge(3600);
            }
        };
    }
}
