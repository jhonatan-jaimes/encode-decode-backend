package com.jejo.encode_decode.short_url.controller;

import com.jejo.encode_decode.short_url.dto.UrlDto;
import com.jejo.encode_decode.short_url.implement.UrlImplement;
import com.jejo.encode_decode.short_url.service.UrlService;
import com.jejo.encode_decode.text.entity.TextEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/api")
public class UrlController {


    private final UrlService urlService;

    @Autowired
    public UrlController(UrlImplement urlImplement) {
        this.urlService = urlImplement;
    }

    /*
    * Este endpoint toma el link y busca en la base de datos el hash y si lo encuentra redirige,
    * al link original asociado al hash
    * */
    @GetMapping("/{text}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String text) {
        try {
            String originalUrl = urlService.getUrlOrigin(text);

            if (!originalUrl.startsWith("http://") && !originalUrl.startsWith("https://")) {
                originalUrl = "https://" + originalUrl;
            }

            // Retorna el recurso encontrado y redirige a la pagina web original.
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(originalUrl))
                    .build();
        } catch (Exception ex) {

            // Retorna un bad request en caso de no cumplirse validaciones programadas.
            return ResponseEntity.badRequest()
                    .body("URL no encontrada: " + ex.getMessage());
        }
    }

    /*
    * El endpoint post "short" resive como parametro un textEntity el cual debe contener el link
    * original de la página web a la que se quiere acortar la url.
    * */
    @PostMapping("/short")
    public ResponseEntity<?> getShort(@Valid @RequestBody UrlDto urlDto){
        try{
            TextEntity textEntity = urlService.createUrl(urlDto);

            // Retorna un status created si tiene exito junto al link recortado.
            return ResponseEntity.status(HttpStatus.CREATED).body(textEntity);
        }catch (Exception ex){

            // Si la peticion no se puede completar retorna un badRequest.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No se puede resolver la peticion" + ex.getMessage());
        }
    }

}
