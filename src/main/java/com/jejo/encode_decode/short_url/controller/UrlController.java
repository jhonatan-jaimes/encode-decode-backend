package com.jejo.encode_decode.short_url.controller;

import com.jejo.encode_decode.short_url.implement.UrlImplement;
import com.jejo.encode_decode.short_url.service.UrlService;
import com.jejo.encode_decode.text.entity.TextEntity;
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

    @GetMapping("/{text}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String text) {
        try {
            String originalUrl = urlService.getUrlOrigin(text);

            if (!originalUrl.startsWith("http://") && !originalUrl.startsWith("https://")) {
                originalUrl = "https://" + originalUrl;
            }

            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(originalUrl))
                    .build();

        } catch (Exception ex) {
            return ResponseEntity.badRequest()
                    .body("URL no encontrada: " + ex.getMessage());
        }
    }

    @PostMapping("/short")
    public ResponseEntity<?> getShort(@RequestBody TextEntity text){
        try{
            TextEntity textEntity = urlService.createUrl(text);

            return ResponseEntity.status(HttpStatus.CREATED).body(textEntity);
        }catch (Exception ex){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No se puede resolver la peticion" + ex.getMessage());
        }
    }

}
