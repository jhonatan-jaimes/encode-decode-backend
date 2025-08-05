package com.jejo.encode_decode.short_url.controller;

import com.jejo.encode_decode.short_url.implement.UrlImplement;
import com.jejo.encode_decode.short_url.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UrlController {


    private final UrlService urlService;

    @Autowired
    public UrlController(UrlImplement urlImplement) {
        this.urlService = urlImplement;
    }

    @GetMapping("/short")
    public ResponseEntity<?> getUrl(@RequestParam String text){
        try{
            String urlOrigin = urlService.getUrlOrigin(text);
            return ResponseEntity.status(302)
                    .header("Location", urlOrigin)
                    .build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Elemento no encontrado, " + ex);
        }
    }

}
