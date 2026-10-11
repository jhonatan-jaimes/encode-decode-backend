package com.jejo.encode_decode.home;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    /*
    * Este controlador es creado para el uso en la plataforma RENDER.COM, el cul me permite despertar
    * el servidor nada más se abra la página web que vaya a consumir este servicio, ya que tom 3 segundos
    * en reiniciar el servicio en su capa gratuita.
    * */
    @GetMapping("/wake-up")
    public ResponseEntity<HomeDto> wakeUp(){

        // Retorna el status 200 OK nada mas.
        return ResponseEntity.status(HttpStatus.OK).body(new HomeDto("He despertado"));
    }
}
