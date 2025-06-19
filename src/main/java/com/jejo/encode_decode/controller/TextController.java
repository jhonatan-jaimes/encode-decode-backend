package com.jejo.encode_decode.controller;

import com.jejo.encode_decode.entity.DecodeEntity;
import com.jejo.encode_decode.entity.EncodeEntity;
import com.jejo.encode_decode.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class TextController {

    private final TextService textService;

    @Autowired
    public TextController(TextService textService) {
        this.textService = textService;
    }

    @PostMapping("/encode")
    public ResponseEntity<EncodeEntity> encodeText(@RequestBody EncodeEntity encodeEntity){
        return ResponseEntity.ok(textService.encodeEntity(encodeEntity));
    }

    @PostMapping("/decode")
    public ResponseEntity<DecodeEntity> decodeText(@RequestBody DecodeEntity decodeEntity){
        return ResponseEntity.ok(textService.decodeEntity(decodeEntity));
    }
}
