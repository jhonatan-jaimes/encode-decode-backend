package com.jejo.encode_decode.qr_text.controller;

import com.jejo.encode_decode.qr_text.entity.QrEntity;
import com.jejo.encode_decode.qr_text.service.QrServices;
import com.jejo.encode_decode.text.entity.TextEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QrController {

    private final QrServices qrServices;

    public QrController(QrServices qrServices) {
        this.qrServices = qrServices;
    }

    @PostMapping("/get-qr")
    public ResponseEntity<QrEntity> getQr(@RequestBody TextEntity textEntity){
        return ResponseEntity.ok(qrServices.qrEntity());
    }
}
