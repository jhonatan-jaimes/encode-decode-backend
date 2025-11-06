package com.jejo.encode_decode.text.controller;

import com.jejo.encode_decode.text.dto.TextDto;
import com.jejo.encode_decode.text.entity.TextEntity;
import com.jejo.encode_decode.text.service.TextService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TextController {

    private final TextService textService;

    @Autowired
    public TextController(TextService textService) {
        this.textService = textService;
    }

    //Si el intento es correcto devuelve 'TextEntity', pero si falla devuelve una exception por eso <?>
    @PostMapping("/encode")
    public ResponseEntity<?> encodeText(@Valid @RequestBody TextDto encodeEntity){

        return ResponseEntity.ok(textService.encodeEntity(encodeEntity));
    }

    //Si el intento es correcto devuelve 'TextEntity', pero si falla devuelve una exeption por eso <?>
    @PostMapping("/decode")
    public ResponseEntity<?> decodeText(@Valid @RequestBody TextDto decodeEntity){

        return ResponseEntity.ok(textService.decodeEntity(decodeEntity));
    }
}
