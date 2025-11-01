package com.jejo.encode_decode.qr_text.controller;

import com.jejo.encode_decode.qr_text.dto.QrTextDto;
import com.jejo.encode_decode.qr_text.entity.QrEntity;
import com.jejo.encode_decode.qr_text.implement.QrImplement;
import com.jejo.encode_decode.qr_text.service.QrServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QrController {

    private final QrServices qrServices;

    @Autowired
    public QrController(QrServices qrServices) {
        this.qrServices = qrServices;
    }

    /*
    * un endpoint cuyo funcionamiento es el crear un código QR tras recibir un texto para la creation de la
    * imagen QR, se genera validation desde la clase RECORD, para retornar las exceptions.
    * */
    @PostMapping("/get-qr")
    public ResponseEntity<QrEntity> getQr(@Valid @RequestBody QrTextDto dto){

        // Intenta crear la imagen QR
        return ResponseEntity.status(HttpStatus.CREATED).body(qrServices.qrEntity(dto));
    }
}
