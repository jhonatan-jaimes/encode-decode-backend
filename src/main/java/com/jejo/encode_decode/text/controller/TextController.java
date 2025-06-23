package com.jejo.encode_decode.text.controller;

import com.jejo.encode_decode.text.entity.TextEntity;
import com.jejo.encode_decode.text.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class TextController {

    private final TextService textService;

    @Autowired
    public TextController(TextService textService) {
        this.textService = textService;
    }

    @PostMapping("/encode")
    public ResponseEntity<TextEntity> encodeText(@RequestBody TextEntity encodeEntity){
        return ResponseEntity.ok(textService.encodeEntity(encodeEntity));
    }

    @PostMapping("/decode")
    public ResponseEntity<TextEntity> decodeText(@RequestBody TextEntity decodeEntity){
        return ResponseEntity.ok(textService.decodeEntity(decodeEntity));
    }
}
