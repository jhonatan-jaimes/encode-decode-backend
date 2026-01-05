package com.jejo.encode_decode.hash_code.controller;

import com.jejo.encode_decode.hash_code.dto.HashDto;
import com.jejo.encode_decode.hash_code.dto.HashOutDot;
import com.jejo.encode_decode.hash_code.service.HashService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HashController {

  private final HashService hashService;

  @Autowired
  public HashController(HashService hashService){
    this.hashService = hashService;
  }

  @PostMapping("/get-hash")
  public ResponseEntity<HashOutDot> getHash(@RequestBody @Valid HashDto hashDto){
    return ResponseEntity.status(HttpStatus.OK).body(hashService.getHash(hashDto));
  }
}
