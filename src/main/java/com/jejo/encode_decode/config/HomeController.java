package com.jejo.encode_decode.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ok")
public class HomeController {
    @GetMapping("/wake-up")
    public ResponseEntity<HttpStatus> wakeUp(){
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
